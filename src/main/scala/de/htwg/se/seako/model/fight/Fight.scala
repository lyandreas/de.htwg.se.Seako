package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.{Cell, Player}
import de.htwg.se.seako.model.fight._

import scala.util.Random

class Fight(playerOne: Player, playerTwo: Player, cell: Cell){
  var r = scala.util.Random
  if (r.nextInt(1)%2 == 0) {
    new WinStrategy(playerOne)
  } else {
    new LossStrategy(playerOne)
  }
}
