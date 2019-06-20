package de.htwg.se.seako.controller.controllerComponent

object GameStatus extends Enumeration{
  type GameStatus = Value
  val IDLE, SELECT, SET, ATTACK, FIGHT, AFTERMATH, WIN, LOSS, NEXT_PLAYER, END = Value

  val map = Map[GameStatus, String] (
    IDLE -> "",
    SELECT -> "",
    SET -> "",
    ATTACK -> "Player choose Cell to attack",
    FIGHT -> "Game is in fighting mode",
    AFTERMATH -> "Aftermath of the fight",
    WIN -> "Aggressor won the battle",
    LOSS -> "Defendant won the battle",
    END -> "Game is over"
  )

  def message(gameStatus: GameStatus) = {
    map(gameStatus)
  }
}
