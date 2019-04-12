package de.htwg.se.seako.model

import org.scalatest.{WordSpec, Matchers}

class PlayerSpec extends WordSpec with Matchers{
    "A Player" when { "new "should{
     val player = Player("Bob", 1)
      "have a name" in {
        player.name should be("Bob")
      }
      "have a nice String reprensentation" in {
        player.toString() should be ("Bob")
      }
      "and should have the number" in {
        player.getNumber should be (1)
      }
    }}
}
