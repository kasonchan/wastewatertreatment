package wastewatertreatment.objects.secondarytreatment.secondaryclarifiers

import wastewatertreatment.core
import wastewatertreatment.objects.secondarytreatment.secondaryclarifiers.SecondaryClarifiers._
import wastewatertreatment.objects.secondarytreatment.secondaryclarifiers.Unit._
import wastewatertreatment.valueunit.ValueUnit

/**
 * Created by kasonchan on 11/9/15.
 */
object ValueUnits extends core.ValueUnits {

  /**
   * TSS removal
   * @param value Default value is '''45.00'''.
   * @param unit Default unit is '''%'''.
   */
  case class TSSRemoval(value: Double = tssRemoval,
                        unit: String = tssRemovalUnits.headOption.getOrElse("%")) extends ValueUnit

  /**
   * BOD removal
   * @param value Default value is '''25.00'''.
   * @param unit Default unit is '''%'''.
   */
  case class BODRemoval(value: Double = bodRemoval,
                        unit: String = bodRemovalUnits.headOption.getOrElse("%")) extends ValueUnit

  /**
   * P/VSS
   * @param value Default value is '''0.02'''.
   * @param unit Default unit is '''No unit'''.
   */
  case class PVSSRatio(value: Double = pVSSRatio,
                       unit: String = pVSSRatioUnits.headOption.getOrElse("")) extends ValueUnit

}
