package wastewatertreatment.objects.advancedsecondarytreatment.filters

import wastewatertreatment.core.Units

/**
 * Created by ka-son on 11/7/15.
 */
object Unit extends Units {

  val dailyBackwashRateUnits = generateUs(rateUnits, areaUnits)

  val bodRemovalUnits = percentageUnits

  val tssRemovalUnits = percentageUnits

  val tocRemovalUnits = percentageUnits

  val fecalColiformRemovalUnits = percentageUnits

  val tpRemovalUnits = percentageUnits

  val tknRemovalUnits = percentageUnits

  val nh3nRemovalUnits = percentageUnits

}
