package wastewatertreatment.objects.pretreatment.primaryclarifiers

import wastewatertreatment.assumptions.Assumptions
import wastewatertreatment.core.Core
import wastewatertreatment.massbalance.MassBalance

/**
 * Created by kasonchan on 11/9/15.
 */
object PrimaryClarifiers extends Assumptions with Core with MassBalance {

  /**
   * TSS removal = 63.00%.
   */
  val tssRemoval = 63.00

  /**
   * BOD removal = 35.00%.
   */
  val bodRemoval = 35.00

  /**
   * TSS = 40000.00g/m^3^.
   */
  val tss = 40000.00

  /**
   * Phosphorus removal = 0.00%.
   */
  val phosphorusRemoval = 0.00

}
