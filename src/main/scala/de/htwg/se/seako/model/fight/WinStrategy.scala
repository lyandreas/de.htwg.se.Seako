package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell

class WinStrategy() extends FightStrategyTemplate {

  println("Player Won")

  override def outcome(): Boolean = true
}
