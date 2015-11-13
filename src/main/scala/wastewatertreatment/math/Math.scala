package wastewatertreatment.math

/**
 * Created by kasonchan on 10/26/15.
 */
object Math {

  /**
   * Returns the decimal number in X decimal places.
   * @param d the decimal number.
   */
  def toXDecimals(d: Double, x: Int = 2): Double = {
    BigDecimal(d).setScale(x, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  /**
   * Returns the value of flow measurement in m^3^/d.
   * {{{
   *   d * 3785.41
   * }}}
   * @param d the value of flow in MGD.
   */
  def tom3d(d: Double): Double = {
    val r = d * 3785.41
    toXDecimals(r)
  }

}