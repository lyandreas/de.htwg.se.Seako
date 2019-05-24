package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell

import scala.util.Random

class Fight(cell: Cell) extends FightStrategyTemplate {
  var r = Random.nextInt(100)
  var outcomeFight = false
  print("test2")
  if (r % 2 == 0) {
    outcomeFight= new WinStrategy(cell).outcome()
    print(outcomeFight)
  }  else {
    outcomeFight = new LossStrategy().outcome()
    print(outcomeFight)
  }
  override def outcome(): Boolean = outcomeFight
}
