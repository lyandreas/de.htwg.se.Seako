package de.htwg.se.seako.controller.controllerComponent

object GameStatus extends Enumeration {
  type GameStatus = Value
  val IDLE, RESIZE, SET, NEW, UNDO, REDO, LOADED, COULD_NOT_LOAD, SAVED,
  COULD_NOT_SAVE, CANDIDATES, SOLVED, NOT_SOLVABLE = Value

  val map = Map[GameStatus, String](
    IDLE -> "",
    NEW -> "A new game was created",
    SET -> "A Cell was set",
    RESIZE -> "Game was resized",
    UNDO -> "Undone one step",
    CANDIDATES -> "Showing candidates",
    REDO -> "Redone one step",
    SOLVED -> "Game successfully solved",
    NOT_SOLVABLE -> "Game not solvable",
    LOADED -> "A new Game was loaded",
    COULD_NOT_LOAD -> "The file could not be loaded",
    SAVED -> "The Game was saved",
    COULD_NOT_SAVE -> "The game could not be saved"
  )

  def message(gameStatus: GameStatus) = {
    map(gameStatus)
  }

}
