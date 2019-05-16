package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.Observable
import de.htwg.se.seako.controller.controllerComponent.GameStatus._

class Controller(var field: Field[Cell], var currentPlayer: CurrentPlayer) extends Observable{

  var gameStatus: GameStatus = IDLE
  def createEmptyField(size: Int): Unit = {
    field = new Field[Cell](size, Cell())
    notifyObservers
  }

  def fieldToString: String = field.toString

  def set(row: Int, col: Int, cell: Cell): Unit = {
    field = field.replaceCell(row: Int, col: Int, cell: Cell) : Field[Cell]
    notifyObservers
  }

}
