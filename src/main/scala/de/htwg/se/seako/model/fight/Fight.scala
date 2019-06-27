package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell
import de.htwg.se.seako.model.Symbol

import scala.util.Random

class Fight(symbol1: Symbol, symbol2: Symbol) extends FightStrategyTemplate {
  var outcomeFight = false

  if (symbol1.symbol == 1 && symbol2.symbol == 3){
    outcomeFight= new WinStrategy().outcome()
  }
  if (symbol1.symbol == 2 && symbol2.symbol == 1){
    outcomeFight= new WinStrategy().outcome()
  }
  if (symbol1.symbol == 3 && symbol2.symbol == 2){
    outcomeFight= new WinStrategy().outcome()
  }
  if (symbol1.symbol == 1 && symbol2.symbol == 2){
    outcomeFight= new LossStrategy().outcome()
  }
  if (symbol1.symbol== 2 && symbol2.symbol == 3){
    outcomeFight= new LossStrategy().outcome()
  }
  if (symbol1.symbol == symbol2.symbol && symbol1.symbol != 0 && symbol2.symbol != 0){
    outcomeFight= new LossStrategy().outcome()
  } else {
    print("Warte auf eingabe")
  }
  /*var r : Integer= Random.nextInt(100)
  var outcomeFight = false
  if (r % 2 == 0) {
    outcomeFight= new WinStrategy().outcome()
    println(outcomeFight)
  }  else {
    outcomeFight = new LossStrategy().outcome()
    println(outcomeFight)
  }*/
  override def outcome(): Boolean = outcomeFight
}
