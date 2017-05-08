package example

import org.scalatest._

class HelloSpec extends WordSpec with Matchers {
  "blubs" in {
    1 shouldBe 1
  }
}
