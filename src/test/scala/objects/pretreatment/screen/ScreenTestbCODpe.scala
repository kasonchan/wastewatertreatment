package objects.pretreatment.screen

import Screen.calbCODpe
import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by kasonchan on 10/26/15.
 */
class ScreenTestbCODpe extends FlatSpec with Matchers {

  "calbCODpe(-1, -1, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(-1, -1, -1)
    }
  }

  "calbCODpe(-1, -1, 0)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(-1, -1, 0)
    }
  }

  "calbCODpe(-1, 0, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(-1, 0, -1)
    }
  }

  "calbCODpe(-1, 0, 0)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(-1, 0, 0)
    }
  }

  "calbCODpe(0, -1, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(0, -1, -1)
    }
  }

  "calbCODpe(0, -1, 0)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(0, -1, 0)
    }
  }

  "calbCODpe(0, 0, -1)" should "fail" in {
    intercept[java.lang.IllegalArgumentException] {
    calbCODpe(0, 0, -1)
    }
  }

  "calbCODpe(0, 0, 0)" should "= 0" in {
    calbCODpe(0, 0, 0) shouldBe 0
  }

  "calbCODpe(130.23, 1.42, 0.8)" should "= 187.98" in {
    calbCODpe(130.23, 1.42, 0.8) shouldBe 147.94
  }

}