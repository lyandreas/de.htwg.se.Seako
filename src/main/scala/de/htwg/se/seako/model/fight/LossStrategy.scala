package de.htwg.se.seako.model.fight

import de.htwg.se.seako.model.Cell

class LossStrategy() extends FightStrategyTemplate {
  println("Player loss the battle")

  override def outcome(): Boolean = false
}
