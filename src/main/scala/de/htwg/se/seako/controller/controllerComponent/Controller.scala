package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.{Observable, UndoManager}
import de.htwg.se.seako.controller.controllerComponent.GameStatus._
import de.htwg.se.seako.model.fight.Fight
import de.htwg.se.seako.aview.Tui

import scala.util.Random



class Controller(var field: Field[Cell], val currentPlayer: CurrentPlayer[Player]) extends Observable{

  var gameStatus: GameStatus = IDLE
  private val undoManager = new UndoManager


  var symbol1 = Symbol(0)
  var symbol2 = Symbol(0)
  var attackerRow  : Int = -1
  var attackerCol : Int = -1
  var defenderRow : Int = -1
  var defenderCol : Int = -1


  var p1Points : Int = 0
  var p2Points : Int = 0
  var p3Points : Int = 0
  var p4Points : Int = 0

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
      set(row, col, Cell(0, isHighlighted = false, currentPlayer.getCurrentPlayer))
      attackerRow = row
      attackerCol = col
      dehighlight()
      highlight(row, col, currentPlayer.getCurrentPlayer)
    } else if (getSelectedCell(row, col).isHighlighted) {
      print("Angreifer waehlt Feld ("+ row + "|" + col+") aus")
      fightCell(row, col)
      var s1 = Symbol(0)
      var s2 = Symbol(0)

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
    if (row + 1 < field.size && col - 1 >= 0 && getSelectedCell(row+1, col-1).player != player) {
      set(row + 1, col - 1, Cell(getSelectedCell(row + 1, col - 1).value , isHighlighted = true, getSelectedCell(row + 1, col - 1).player)) // links unten
    }
    if (row + 1 < field.size && getSelectedCell(row + 1, col).player != player) {
      set(row + 1, col, Cell(getSelectedCell(row + 1, col).value, isHighlighted = true, getSelectedCell(row + 1, col).player)) // mitte unten
    }
    if (row+1 < field.size && col+1 < field.size && getSelectedCell(row+1, col+1).player != player) {
      set(row + 1, col + 1, Cell(getSelectedCell(row + 1, col + 1).value,isHighlighted =  true, getSelectedCell(row + 1, col + 1).player)) //rechts unten
    }
  }

  def dehighlight(): Unit = {

    for (col <- 0 until field.size) {
      for (row <- 0 until field.size) {
        if(getSelectedCell(row,col).isHighlighted) {
          set(row, col, Cell(getSelectedCell(row, col).value , isHighlighted = false, getSelectedCell(row, col).player))

        }
      }
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

  def removePlayer(player: Player) : Unit = {
    currentPlayer.remove(player)
  }

  def currentPlayerVector(): Unit = {
    currentPlayer.playerVector foreach println
  }

  def fightCell(row:Int, col:Int): Unit = {
    gameStatus = FIGHT
    defenderRow = row
    defenderCol = col

    if (getSelectedCell(defenderRow,defenderCol).player.equals(Player("Computer"))) {
      var r = scala.util.Random
      symbol2 = Symbol(r.nextInt(3) + 1)
    }

  }

  def startFight() : Unit = {

    var fight = new Fight(symbol1, symbol2, getSelectedCell(defenderRow,defenderCol).player.name.equals("Computer"))
    fight.outcome() //TRUE PLAYER ! gewonen

    if (fight.outcome()) {
      currentPlayer.getCurrentPlayer match {
        case Player("Player1") => p1Points = p1Points + 1
        case Player("Player2") => p2Points = p2Points + 1
        case Player("Player3") => p3Points = p3Points + 1
        case Player("Player4") => p4Points = p4Points + 1

      }
      getSelectedCell(defenderRow,defenderCol).player match {
        case Player("Player1") => p1Points = p1Points - 1
        case Player("Player2") => p2Points = p2Points - 1
        case Player("Player3") => p3Points = p3Points - 1
        case Player("Player4") => p4Points = p4Points - 1
        case Player("Computer") =>
      }
      set(defenderRow, defenderCol, Cell(0, isHighlighted = false, currentPlayer.getCurrentPlayer))
    } else if (getSelectedCell(defenderRow, defenderCol).player != Player("Computer")) {

      getSelectedCell(defenderRow,defenderCol).player match {
        case Player("Player1") => p1Points = p1Points + 1
        case Player("Player2") => p2Points = p2Points + 1
        case Player("Player3") => p3Points = p3Points + 1
        case Player("Player4") => p4Points = p4Points + 1
      }
      currentPlayer.getCurrentPlayer match {
        case Player("Player1") => p1Points = p1Points - 1
        case Player("Player2") => p2Points = p2Points - 1
        case Player("Player3") => p3Points = p3Points - 1
        case Player("Player4") => p4Points = p4Points - 1

      }

      set(attackerRow, attackerCol, Cell(0, isHighlighted = false, getSelectedCell(defenderRow, defenderCol).player))
    }
    notifyObservers
    attackerRow = -1
    attackerCol = - 1
    defenderRow = -1
    defenderCol = -1
    symbol1 = Symbol(0)
    symbol2 = Symbol(0)

    dehighlight()
    checkWinnner()
    nextTurn()
  }

  def setSymbol(symbol: Int) : Unit = {
    var output = ""
      if (gameStatus == FIGHT ) {
        if (symbol1 == Symbol(0)) {
          symbol match {
            case 1 => symbol1 = Symbol(1)
              output = "Angreifer waehlt Schere aus"
            case 2 => symbol1 = Symbol(2)
              output = "Angreifer waehlt Stein aus"
            case 3 => symbol1 = Symbol(3)
              output = "Angreifer waehlt Schere aus"
          }

      } else if (symbol1 != Symbol(0) && symbol2 == Symbol(0)) {
          symbol match {
            case 1 => symbol2 = Symbol(1)
              output = "Defender waehlt Schere aus"
            case 2 => symbol2 = Symbol(2)
              output = "Defender waehlt Stein aus"
            case 3 => symbol2 = Symbol(3)
              output = "Defender waehlt Schere aus"
          }
        }
    } else {
        output = "Man muss sich im Kampf befinden, um kämpfen zu können"
      }
    print(output)
  }

  def checkWinnner(): Unit = {

    if (p1Points > 0 && p2Points == 0 && p3Points == 0 && p4Points == 0) {
      print("Spieler 1 Gewinnt")
      gameStatus = END
    }
    if (p1Points == 0 && p2Points > 0 && p3Points == 0 && p4Points == 0) {
      print("Spieler 2 Gewinnt")
      gameStatus = END
    }
    if (p1Points == 0 && p2Points == 0 && p3Points > 0 && p4Points == 0) {
      print("Spieler 3 Gewinnt")
      gameStatus = END
    }
    if (p1Points == 0 && p2Points == 0 && p3Points > 0 && p4Points == 0) {
      print("Spieler 4 Gewinnt")
      gameStatus = END
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
