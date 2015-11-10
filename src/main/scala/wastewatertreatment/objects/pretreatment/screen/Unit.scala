package wastewatertreatment.objects.pretreatment.screen

import wastewatertreatment.valueunit

/**
 * Created by kasonchan on 10/25/15.
 */
object Unit extends valueunit.Unit {

  val tssRemovalUnits = percentageUnits

  val bod5RemovalUnits = percentageUnits

  val qUnits = flowUnits

  val tssOUnits = concentrationUnits

  val tssEUnits = concentrationUnits

  val bod5OUnits = concentrationUnits

  val bod5EUnits = concentrationUnits

  val bod5cBOD5Units = noUnits

  val codBODUnits = noUnits

  val codVSSUnits = noUnits

  val vssTSSUnits = noUnits

  val vsseUnits = concentrationUnits

  val cBOD5eUnits = concentrationUnits

  val bCODeUnits = concentrationUnits

  val bCODpeUnits = concentrationUnits

  val bCODsUnits = concentrationUnits

  val pUnits = generatePRUs(massUnits, "TSS", dayUnits)

}