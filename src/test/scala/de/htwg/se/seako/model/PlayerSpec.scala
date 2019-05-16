package de.htwg.se.seako.model

import org.scalatest.{WordSpec, Matchers}

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when {
    "new " should {
      val player = Player("Bob", 1)
      "have a name" in {
        player.name should be("Bob")
      }
      "have a nice String reprensentation" in {
        player.toString() should be("Bob")
      }
      "and should have the number" in {
        player.getNumber should be(1)
      }
    }
    "named Karl" should {
      val player2 = Player("Karl", 2)
      "have the name" in {
        player2.name should be ("Karl")
      }
      "have a nice String representation" in {
        player2.toString() should be ("Karl")
      }
      "and should have the number" in {
        player2.getNumber should be (2)
      }
    }
  }
}
