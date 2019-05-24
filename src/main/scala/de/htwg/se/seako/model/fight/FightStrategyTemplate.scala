package de.htwg.se.seako.model.fight

trait FightStrategyTemplate {
  def WinStrategy (): Unit
  def LossStrategy(): Unit
  def Fight(): Unit
}
