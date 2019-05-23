package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.{Cell, Field, Player}

class WinStrategy(var field: Field[Cell], row:Int, col: Int, player: Player)extends FightStrategyTemplate {
  print(player + "won the fight")
  field.replaceCell(row,col,Cell(123,123,"T"))

}
