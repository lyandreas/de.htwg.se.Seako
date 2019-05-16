package de.htwg.se.seako.controller.controllerComponent

object GameStatus extends Enumeration{
  type GameStatus = Value
  val IDLE, PLAYERPHASE, SET, FIGHT, AFTERMATH, WIN, LOSS, END = Value

  val map = Map[GameStatus, String] (
    IDLE -> "",
    PLAYERPHASE -> "Game choose next player",
    SET -> "Player can choose a Cell",
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
