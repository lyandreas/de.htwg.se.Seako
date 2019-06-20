package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.{Observable, UndoManager}
import de.htwg.se.seako.controller.controllerComponent.GameStatus._
import de.htwg.se.seako.model.fight.Fight
import de.htwg.se.seako.aview.Tui



class Controller(var field: Field[Cell], val currentPlayer: CurrentPlayer[Player]) extends Observable{

  var gameStatus: GameStatus = IDLE
  private val undoManager = new UndoManager
  var size = 6


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
    if (currentPlayer.getCurrentPlayer.equals(Cell(row, col).player)) {
      print("LLELFEQLF")
      highlight(row, col, currentPlayer.getCurrentPlayer)
    }
    print(currentPlayer.getCurrentPlayer + " " + Cell(row,col).player)
    notifyObservers
  }

  def highlight(row: Int, col: Int, player: Player): Unit = {
    if (row - 1 >= 0 && col - 1 >= 0 && Cell(row - 1, col -1).player != player) {
      set(row - 1, col - 1, Cell(row - 1, col - 1,"H",true))
    }
    else if (row - 1 >= 0 && Cell(row - 1, col).player != player) {
      set(row - 1, col, Cell(row - 1, col,"H",true))
    }
    else if (row -1 >= 0 && col + 1 < size && Cell(row - 1, col + 1).player != player) {
      set(row -1, col +1, Cell(row -1, col +1,"H",true))
    }
    else if (col -1 >= 0 && Cell(row, col - 1).player != player) {
      set(row, col -1, Cell(row, col -1,"H",true))
    }
    else if (col+1 < size && Cell(row, col+1).player != player) {
      set(row, col+1, Cell(row, col+1,"H",true))
    }
    else if (row+1 < size && col-1 > 0 && Cell(row+1, col-1).player != player) {
      set(row+1, col-1, Cell(row+1, col-1,"H",true))
    }
    else if (row+1 < size && Cell(row+1, col).player != player) {
      set(row+1, col, Cell(row+1, col,"H",true))
    }
    else if (row+1 < size && col+1 < size && Cell(row+1, col+1).player != player) {
      set(row+1, col+1, Cell(row+1, col+1,"H",true))
    }
  }

  def set(row: Int, col: Int, cell: Cell): Unit = {
    gameStatus = SET
    undoManager.doStep(new SetCommand(row, col, cell, this))
    notifyObservers
  }

  def nextTurn(): Unit = {
    currentPlayer.nextPlayer()
  }

  def getCurrentPlayer(): Player = {
    print(currentPlayer.getCurrentPlayer)
    currentPlayer.getCurrentPlayer
  }

  def addPlayer(player: Player): Unit = {
    currentPlayer.add(player)
  }

  def currentPlayerVector: Unit = {
    currentPlayer.playerVector foreach println
  }

  def fight(row:Int, col:Int,cell: Cell): Unit = {

    gameStatus = FIGHT

    var fightOutcome = new Fight(cell)
    print(fightOutcome)
    if (fightOutcome.outcome()) {
      set(row,col,cell)
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
