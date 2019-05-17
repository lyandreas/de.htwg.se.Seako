package de.htwg.se.seako.model

import scala.util.Random

class Dice (values: Int) extends Fight {

  val sides = 5
  val r = Random
  var diceValue = 0
  var diceValue2 = 0
  var numberOfthrows = 1
  //var dices = Vector[Int]()

  for (i <- 1 to numberOfthrows) {
    diceValue = 0
    diceValue2 = 0
    diceValue = r.nextInt(sides + 1)
    diceValue2 = r.nextInt(sides + 1)
    dices = dices :+ diceValue
  }
  dices
}
