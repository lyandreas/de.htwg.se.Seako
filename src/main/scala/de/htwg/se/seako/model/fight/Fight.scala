package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell

import scala.util.Random

abstract class Fight(cell: Cell) extends FightStrategyTemplate {
  var r = Random
  r.nextInt(1)%2 == 0

  var i = 0

  if (r == 0){
    i = 0
  } else {
    i = 1
  }

  override def WinStrategy(): Unit = {  }

  override def LossStrategy(): Unit = new LossStrategy() {}


  override def Fight(): Unit = new Fight(){}

}
