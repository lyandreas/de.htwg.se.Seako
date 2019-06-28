package de.htwg.se.seako.model

import org.scalatest.{WordSpec, Matchers}

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new " should {
      val player = Player("Bob")
      "have a name" in {
        player.name should be("Bob")
      }
      "have a nice String reprensentation" in {
        player.toString() should be("Bob")
      }
    }
    "named Karl" should {
      val player2 = Player("Karl")
      "have the name" in {
        player2.name should be ("Karl")
      }
      "have a nice String representation" in {
        player2.toString() should be ("Karl")
      }
    }
  }
}
