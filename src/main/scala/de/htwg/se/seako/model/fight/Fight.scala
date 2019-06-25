package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell

import scala.util.Random

class Fight(cell: Cell) extends FightStrategyTemplate {
  var r : Integer= Random.nextInt(100)
  var outcomeFight = false
  if (r % 2 == 0) {
    outcomeFight= new WinStrategy(cell).outcome()
    println(outcomeFight)
  }  else {
    outcomeFight = new LossStrategy().outcome()
    println(outcomeFight)
  }
  override def outcome(): Boolean = outcomeFight
}
