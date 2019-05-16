package de.htwg.se.seako.controller.controllerComponent

class GameStatus extends Enumeration{
  type GameStatus = Value
  val IDLE, SET, FIGHT, END= Value

  val map = Map[GameStatus, String] (
    IDLE -> "",
    SET -> "",
    FIGHT -> "Game is in fighting mode",
    END -> "Game is over"
  )

  def message(gameStatus: GameStatus) = {
    map(gameStatus)
  }
}
