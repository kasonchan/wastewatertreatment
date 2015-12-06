package wastewatertreatment.core

import equations.massbalance.MassBalance.{MX, solveMX}
import equations.monooperation.MonoOperation.solveM
import wastewatertreatment.ratios.Ratios

/**
 * Created by kasonchan on 11/15/15.
 */
trait Core extends Ratios {

  /**
   * Returns the value of effluent constituent.
   * {{{
   *   Qo * Xo + ... = Qe * Xe + ...
   * }}}
   * @param inputs the list of inputs.
   * @param outputs the list of outputs.
   */
  def calMX(inputs: List[MX], outputs: List[MX]): Option[Double] = {
    inputs.headOption.getOrElse(MX(None, None, None)) match {
      case MX(_, x: Option[Double], None) => x
      case MX(_, _, Some(_)) => solveMX(inputs, outputs)
      case _ => None
    }
  }

  /**
   * Returns VSS.
   * {{{
   *   VSS = TSS * vssTSSRatio
   * }}}
   * @param TSS the initial value of TSS.
   * @param vssTSSRatio VSS/TSS. Default value and unit are 0.80.
   */
  def calVSS(TSS: Double,
             vssTSSRatio: Double = vssTSSRatio): Double = {
    require(TSS >= 0 && vssTSSRatio >= 0)
    val r = solveM(List(None), List(Some(TSS), Some(vssTSSRatio)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns VSS or TSS.
   * {{{
   *   VSS = TSS * vssTSSRatio
   * }}}
   * @param VSS the initial value of VSS. Default value is 0.00.
   * @param TSS the initial value of TSS. Default value is 0.00.
   * @param vssTSS VSS/TSS. Default value and unit are 0.80.
   */
  def calVSSTSS(VSS: Option[Double] = None,
                TSS: Option[Double] = None,
                vssTSS: Option[Double] = Some(vssTSSRatio)): Double = {
    require(VSS.getOrElse(0.0) >= 0 &&
      TSS.getOrElse(0.0) >= 0 &&
      vssTSS.getOrElse(0.0) >= 0)
    val r = solveM(List(VSS), List(TSS, vssTSS), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns cBOD,,5,,.
   * {{{
   *   cBOD5 = BOD / bod5cBOD5Ratio
   * }}}
   * @param BOD5e the effluent value of BOD,,5,,.
   * @param bod5cBOD5Ratio BOD,,5,,/cBOD,,5,,. Default value and unit are 1.10.
   */
  def calcBOD5(BOD5e: Double,
               bod5cBOD5Ratio: Double = bod5cBOD5Ratio): Double = {
    require(BOD5e >= 0 && bod5cBOD5Ratio >= 0 && bod5cBOD5Ratio > 0)
    val r = solveM(List(None, Some(bod5cBOD5Ratio)), List(Some(BOD5e)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns cBOD,,5,, or BOD,,5,,.
   * {{{
   *   cBOD5 * bod5cBOD5Ratio = BOD5
   * }}}
   * @param cBOD5 the initial value of cBOD,,5,,. Default value is 0.00.
   * @param bod5cBOD5 BOD,,5,,/cBOD,,5,,. Default value and unit are 1.10.
   * @param BOD5 the initial value of BOD,,5,,. Default value is 0.00.
   */
  def calcBOD5BOD5(cBOD5: Option[Double] = None,
                   bod5cBOD5: Option[Double] = Some(bod5cBOD5Ratio),
                   BOD5: Option[Double] = None): Double = {
    require(cBOD5.getOrElse(0.0) >= 0 &&
      bod5cBOD5.getOrElse(0.0) > 0 &&
      BOD5.getOrElse(0.0) >= 0)
    val r = solveM(List(cBOD5, bod5cBOD5), List(BOD5), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns bCOD.
   * {{{
   *   bCOD = BOD5 * codBODRatio
   * }}}
   * @param BOD5 the initial value of BOD,,5,,.
   * @param codBODRatio COD/BOD. Default value and unit are 1.60.
   */
  def calbCOD(BOD5: Double,
              codBODRatio: Double = codBODRatio): Double = {
    require(BOD5 >= 0 && codBODRatio >= 0)
    val r = solveM(List(None), List(Some(BOD5), Some(codBODRatio)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns bCOD or BOD,,5,,.
   * {{{
   *   bCOD = BOD5 * codBODRatio
   * }}}
   * @param bCOD the initial value of bCOD. Default value is 0.00.
   * @param BOD5 the initial value of BOD,,5,,. Default value is 0.00
   * @param codBOD COD/BOD. Default value and unit are 1.60.
   */
  def calbCODBOD5(bCOD: Option[Double] = None,
                  BOD5: Option[Double] = None,
                  codBOD: Option[Double] = Some(codBODRatio)): Double = {
    require(bCOD.getOrElse(0.0) >= 0 &&
      BOD5.getOrElse(0.0) >= 0 &&
      codBOD.getOrElse(0.0) >= 0)
    val r = solveM(List(bCOD), List(BOD5, codBOD), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns bCODp.
   * {{{
   *   bCODp = VSS * codVSSRatio * bvssVSSRatio
   * }}}
   * @param VSS the initial value of VSS.
   * @param codVSSRatio COD/VSS. Default value and unit are 1.42.
   * @param bvssVSSRatio biodegradable VSS. Default value and unit are 0.80.
   */
  def calbCODp(VSS: Double,
               codVSSRatio: Double = codVSSRatio,
               bvssVSSRatio: Double = bvssVSSRatio): Double = {
    require(VSS >= 0 && codVSSRatio >= 0 && bvssVSSRatio >= 0)
    val r = solveM(List(None), List(Some(VSS), Some(codVSSRatio), Some(bvssVSSRatio)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns bCODp or VSS.
   * {{{
   *   bCODp = VSS * codVSSRatio * bvssVSSRatio
   * }}}
   * @param bCODp the initial value of cBODp. Default value is 0.00.
   * @param VSS the initial value of VSS. Default value is 0.00
   * @param codVSS COD/VSS. Default value and unit are 1.42.
   * @param bvssVSS bVSS/VSS. Default value and unit are 0.80.
   */
  def calbCODpVSS(bCODp: Option[Double] = None,
                  VSS: Option[Double] = None,
                  codVSS: Option[Double] = Some(codVSSRatio),
                  bvssVSS: Option[Double] = Some(bvssVSSRatio)): Double = {
    require(bCODp.getOrElse(0.0) >= 0 &&
      VSS.getOrElse(0.0) >= 0 &&
      codVSS.getOrElse(0.0) >= 0 &&
      bvssVSS.getOrElse(0.0) >= 0)
    val r = solveM(List(bCODp), List(VSS, codVSS, bvssVSS), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns bCODs.
   * {{{
   *   bCODs = bCOD - bCODp
   * }}}
   * @param bCOD the initial value of bCOD.
   * @param bCODp the initial value of bCODp.
   */
  def calbCODs(bCOD: Double,
               bCODp: Double): Double = {
    require(bCOD >= 0 && bCODp >= 0)
    val r = solveM(List(None, Some(bCODp)), List(Some(bCOD)), 'add).getOrElse(0.0)
    r
  }

  /**
   * Returns bCODs or bCOD or bCODp.
   * {{{
   *   bCODs = bCOD - bCODp
   * }}}
   * @param bCODs the initial value of bCOD. Default value is 0.00.
   * @param bCOD the initial value of bCOD. Default value is 0.00.
   * @param bCODp the initial value of bCODp. Default value is 0.00.
   */
  def calbCODsbCODpbCOD(bCODs: Option[Double] = None,
                        bCODp: Option[Double] = None,
                        bCOD: Option[Double] = None): Double = {
    require(bCODs.getOrElse(0.0) >= 0 &&
      bCODp.getOrElse(0.0) >= 0 &&
      bCOD.getOrElse(0.0) >= 0)
    val r = solveM(List(bCODs, bCODp), List(bCOD), 'add).getOrElse(0.0)
    r
  }

  /**
   * Returns P.
   * {{{
   *   P = Q * TSS
   * }}}
   * @param Q the initial value of Q.
   * @param TSS the initial value of TSS.
   */
  def calP(Q: Double,
           TSS: Double): Double = {
    require(Q >= 0 && TSS >= 0)
    val r = solveM(List(None), List(Some(Q), Some(TSS)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns P, Q or TSS.
   * {{{
   *   P = Q * TSS
   * }}}
   * @param P the initial value of Q. Default value is 0.00.
   * @param Q the initial value of Q. Default value is 0.00.
   * @param TSS the initial value of TSS. Default value is 0.00.
   */
  def calPQTSS(P: Option[Double] = None,
               Q: Option[Double] = None,
               TSS: Option[Double] = None): Double = {
    require(P.getOrElse(0.0) >= 0 &&
      Q.getOrElse(0.0) >= 0 &&
      TSS.getOrElse(0.0) >= 0)
    val r = solveM(List(P), List(Q, TSS), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns percentage value.
   * {{{
   *   X = X * percentage
   * }}}
   * @param X the initial value of X.
   * @param percentage the percentage of the effluent of X.
   */
  def calXPercentage(X: Double,
                     percentage: Double): Double = {
    require(X >= 0 && percentage >= 0)
    val r = solveM(List(None, Some(100)), List(Some(X), Some(percentage)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns Q.
   * {{{
   *   Q = P / TSS
   * }}}
   * @param P the initial value of P.
   * @param TSS the initial value of TSS.
   */
  def calQ(P: Double,
           TSS: Double): Double = {
    require(P >= 0 && TSS > 0)
    val r = P / TSS
    r
  }

  /**
   * Returns TSS.
   * {{{
   *   TSS = P / Q
   * }}}
   * @param P the initial value of P.
   * @param Q the initial value of Q.
   */
  def calTSS(P: Double,
             Q: Double): Double = {
    require(P >= 0 && Q > 0)
    val r = P / Q
    r
  }

  /**
   * Returns NTU.
   * {{{
   *   NTU = TSS * NTU/TSS
   * }}}
   * @param TSS the effluent value of TSS.
   * @param ntuTSSRatio NTU/TSS. Default value and unit are 0.50.
   */
  def calNTU(TSS: Double,
             ntuTSSRatio: Double = ntuTSSRatio): Double = {
    require(TSS >= 0 && ntuTSSRatio >= 0)
    val r = solveM(List(None), List(Some(TSS), Some(ntuTSSRatio)), 'multiple).getOrElse(0.0)
    r
  }

  /**
   * Returns NTU or TSS.
   * {{{
   *   NTU = TSS * NTU/TSS
   * }}}
   * @param NTU the effluent value of NTU. Default value is 0.00.
   * @param TSS the effluent value of TSS. Default value is 0.00.
   * @param ntuTSS NTU/TSS. Default value and unit are 0.50.
   */
  def calNTUTSS(NTU: Option[Double] = None,
                TSS: Option[Double] = None,
                ntuTSS: Option[Double] = Some(ntuTSSRatio)): Double = {
    require(NTU.getOrElse(0.0) >= 0 &&
      TSS.getOrElse(0.0) >= 0 &&
      ntuTSS.getOrElse(0.0) >= 0)
    val r = solveM(List(NTU), List(TSS, ntuTSS), 'multiple).getOrElse(0.0)
    r
  }

}
