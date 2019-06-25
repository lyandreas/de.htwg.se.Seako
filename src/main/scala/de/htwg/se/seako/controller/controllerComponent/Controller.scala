package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.{Observable, UndoManager}
import de.htwg.se.seako.controller.controllerComponent.GameStatus._
import de.htwg.se.seako.model.fight.Fight
import de.htwg.se.seako.aview.Tui



class Controller(var field: Field[Cell], val currentPlayer: CurrentPlayer[Player]) extends Observable{

  var gameStatus: GameStatus = IDLE
  private val undoManager = new UndoManager


  def createEmptyField(size: Int): Unit = {
    field = new Field[Cell](size, Cell())
    notifyObservers
  }

  def fieldToString: String = field.toString

  def startGame(): Unit = {
    gameStatus = SELECT
  }

  def select(row: Int, col: Int): Unit = {
    gameStatus = SELECT
    if (currentPlayer.getCurrentPlayer.equals(getSelectedCell(row,col).player)) {
      print("LLELFEQLF")
      highlight(row, col, currentPlayer.getCurrentPlayer)
    } else if (getSelectedCell(row, col).isHighlighted) {
      fight(row, col)
    } else if (!getSelectedCell(row, col).isHighlighted && getSelectedCell(row, col).player == currentPlayer.getCurrentPlayer) {
      highlight(row, col,currentPlayer.getCurrentPlayer)
    } else {
      print("Bitte ein eingenes oder gehighlightes Feld auswaehlen\n")
    }
    print(currentPlayer.getCurrentPlayer + " " + getSelectedCell(row,col).player)
    notifyObservers
  }

  def highlight(row: Int, col: Int, player: Player): Unit = {
    if (row - 1 >= 0 && col - 1 >= 0 && getSelectedCell(row - 1, col -1).player != player) {
      set(row - 1, col - 1, Cell(getSelectedCell(row - 1, col - 1).value , isHighlighted = true, getSelectedCell(row - 1, col - 1).player)) //links oben
    }
    if (row - 1 >= 0 && getSelectedCell(row - 1, col).player != player) {
      set(row - 1, col, Cell( getSelectedCell(row - 1, col).value, isHighlighted = true,getSelectedCell(row - 1, col).player)) // mitte oben
    }
    if (row - 1 >= 0 && col + 1 < field.size && getSelectedCell(row - 1, col + 1).player != player) {
      set(row - 1, col + 1, Cell(getSelectedCell(row - 1, col + 1).value, isHighlighted = true, getSelectedCell(row - 1, col + 1).player)) // rechts oben
    }
    if (col - 1 >= 0 && getSelectedCell(row, col - 1).player != player) {
      set(row, col - 1, Cell(getSelectedCell(row, col - 1).value,isHighlighted =  true, getSelectedCell(row, col - 1).player)) // links
    }
    if (col + 1 < field.size && getSelectedCell(row, col + 1).player != player) {
      set(row, col + 1, Cell(getSelectedCell(row, col + 1).value,isHighlighted =  true, getSelectedCell(row, col + 1).player)) // rechts
    }
    if (row + 1 < field.size && col - 1 > 0 && getSelectedCell(row+1, col-1).player != player) {
      set(row + 1, col - 1, Cell(getSelectedCell(row + 1, col - 1).value , isHighlighted = true, getSelectedCell(row + 1, col - 1).player)) // links unten
    }
    if (row + 1 < field.size && getSelectedCell(row + 1, col).player != player) {
      set(row + 1, col, Cell(getSelectedCell(row + 1, col).value, isHighlighted = true, getSelectedCell(row + 1, col).player)) // mitte unten
    }
    if (row+1 < field.size && col+1 < field.size && getSelectedCell(row+1, col+1).player != player) {
      set(row + 1, col + 1, Cell(getSelectedCell(row + 1, col + 1).value,isHighlighted =  true, getSelectedCell(row + 1, col + 1).player)) //rechts unten
    }
  }

  def set(row: Int, col: Int, cell: Cell): Unit = {
    gameStatus = SET
    undoManager.doStep(new SetCommand(row, col, cell, this))
    notifyObservers
  }

  def getSelectedCell(row: Int, col: Int): Cell = {
    field.cell(row, col)
  }

  def nextTurn(): Unit = {
    currentPlayer.nextPlayer()
  }

  def getCurrentPlayer: Player = {
    print(currentPlayer.getCurrentPlayer)
    currentPlayer.getCurrentPlayer
  }

  def addPlayer(player: Player): Unit = {
    currentPlayer.add(player)
  }

  def currentPlayerVector(): Unit = {
    currentPlayer.playerVector foreach println
  }

  def fight(row:Int, col:Int): Unit = {

    gameStatus = FIGHT

    var fightOutcome = new Fight(Cell())
    print(fightOutcome)
    if (fightOutcome.outcome()) {
      set(row,col,Cell(1,isHighlighted = false,currentPlayer.getCurrentPlayer))
    } else {
      notifyObservers
    }
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
