package wastewatertreatment.objects.pretreatment.screen

import org.scalatest.{FlatSpec, Matchers}
import wastewatertreatment.objects.pretreatment.screen.Screen.calP

/**
 * Created by kasonchan on 10/26/15.
 */
class ScreenSuiteP extends FlatSpec with Matchers {

  "calP(-1, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
      calP(-1, -1)
    }
  }

  "calP(-1, 0)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
      calP(-1, 0)
    }
  }

  "calP(0, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
      calP(0, -1)
    }
  }

  "calP(0, 0)" should "= 0" in {
    calP(0, 0) shouldBe 0.0
  }

  "calP(1090195, 130.23)" should "= 1.4197609485E8" in {
    calP(1090195, 130.23) shouldBe 1.4197609485E8
  }

  "calP(VSSe = 130.23)" should "= 1.4197609485E8" in {
    calP(VSSe = 130.23) shouldBe 1.4197609485E8
  }

}