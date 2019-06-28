package de.htwg.se.seako.aview


import de.htwg.se.seako.controller.controllerComponent.{Controller,GameStatus}
import de.htwg.se.seako.model.{Cell, Player}
import de.htwg.se.seako.util.Observer
import de.htwg.se.seako.model.fight.Fight

class Tui(controller: Controller) extends Observer {
  controller.add(this)
  var size = 6

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "n" => controller.createEmptyField(size)
      case "z" => controller.undo()
      case "y" => controller.redo()
      case "s" => controller.startGame()
      case "s-l" =>
        size = 3
        controller.createEmptyField(size)
      case "s-m" =>
        size = 6
        controller.createEmptyField(size)
      case "s-b" =>
        size = 9
        controller.createEmptyField(size)
      case "p2" =>
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1")))
        controller.set(size-1, size-1,Cell(1,isHighlighted = false, Player("Player2")))
        controller.p1Points = 1
        controller.p2Points = 1
      case "p3" =>
        controller.addPlayer(Player("Player3"))
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1")))
        controller.set(size-1,size-1,Cell(1,isHighlighted = false, Player("Player2")))
        controller.set(0,size-1,Cell(1, isHighlighted = false, Player("Player3")))
        controller.p1Points = 1
        controller.p2Points = 1
        controller.p3Points = 1
      case "p4" =>
        if (!controller.currentPlayer.playerVector.contains(Player("Player3"))) {
          controller.addPlayer(Player("Player3"))
        }

        controller.addPlayer(Player("Player4"))
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1")))
        controller.set(size-1,size-1,Cell(1,isHighlighted = false, Player("Player2")))
        controller.set(0,size-1,Cell(1,isHighlighted =  false, Player("Player3")))
        controller.set(size-1, size-1, Cell(1,isHighlighted =  false, Player("Player4")))
        controller.p1Points = 1
        controller.p2Points = 1
        controller.p3Points = 1
        controller.p4Points = 1
      case "c" =>
        controller.getCurrentPlayer
      case "np" =>
        controller.nextTurn()
      case "cp" =>
        controller.currentPlayerVector()

      case "1" => controller.setSymbol(1)

      case "2" => controller.setSymbol(2)

      case "3" => controller.setSymbol(3)

      case "sf" => controller.startFight()

      case "dh" => controller.dehighlight()
      case "r2" => controller.removePlayer(Player("Player2"))
      case _ => input.toList.filter(c => c != ' ').filter(_.isDigit).map(c => c.toString.toInt) match {
          case row :: column :: Nil => controller.select(row,column)
          case row :: column :: value :: Nil => controller.set(row, column, Cell(value,isHighlighted = false,Player("Computer")))
          case _ => println("unknown command")
      }
    }
  }

  override def update: Unit = {
    println(controller.fieldToString)
    println(GameStatus.message(controller.gameStatus))
  }
}