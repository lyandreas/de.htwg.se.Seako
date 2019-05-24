package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.{Observable,UndoManager}
import de.htwg.se.seako.controller.controllerComponent.GameStatus._

class Controller(var field: Field[Cell], val currentPlayer: CurrentPlayer[Player]) extends Observable{

  var gameStatus: GameStatus = IDLE
  private val undoManager = new UndoManager


  def createEmptyField(size: Int): Unit = {
    field = new Field[Cell](size, Cell())
    notifyObservers
  }

  def fieldToString: String = field.toString

  def set(row: Int, col: Int, cell: Cell): Unit = {
    gameStatus = SET
    undoManager.doStep(new SetCommand(row, col, cell, this))
 //   field = field.replaceCell(row: Int, col: Int, cell: Cell) : Field[Cell]
    notifyObservers
  }

  def nextTurn(): Unit = {
    gameStatus = NEXT_PLAYER
    currentPlayer.nextPlayer()
    notifyObservers
  }

  def getCurrentPlayer(): Unit = {
    print(currentPlayer.getCurrentPlayer)
    notifyObservers
  }

  def addPlayer(player: Player): Unit = {
    gameStatus = SETTING_PLAYER
    currentPlayer.add(player)
    notifyObservers
  }

  def currentPlayerVector: String = currentPlayer.toString

  def fight(playerOne: Player,playerTwo: Player): String = {
    gameStatus = FIGHT
    var output =""
    output
  }

  def undo(): Unit = {
    undoManager.undoStep()
    notifyObservers
  }

  def redo(): Unit = {
    undoManager.redoStep()
    notifyObservers
  }


}
