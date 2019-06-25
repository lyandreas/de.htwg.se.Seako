package de.htwg.se.seako.aview


import de.htwg.se.seako.controller.controllerComponent.{Controller,GameStatus}
import de.htwg.se.seako.model.{Cell, Player}
import de.htwg.se.seako.util.Observer

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
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1",1)))
        controller.set(size-1, size-1,Cell(1,isHighlighted = false, Player("Player2",2)))
        //controller.set(0,0,Cell(1,1,"W",false, Player("Player1",1)))
      case "p3" =>
        controller.addPlayer(Player("Player3",3))
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1",1)))
        controller.set(size-1,size-1,Cell(1,isHighlighted = false, Player("Player2",2)))
        controller.set(0,size-1,Cell(1, isHighlighted = false, Player("Player3",3)))
      case "p4" =>
        if (!controller.currentPlayer.playerVector.contains(Player("Player3",3))) {
          controller.addPlayer(Player("Player3",3))
        }

        controller.addPlayer(Player("Player4",4))
        controller.set(0,0,Cell(1,isHighlighted = false, Player("Player1",1)))
        controller.set(size-1,size-1,Cell(1,isHighlighted = false, Player("Player2",2)))
        controller.set(0,size-1,Cell(1,isHighlighted =  false, Player("Player3",3)))
        controller.set(size-1, size-1, Cell(1,isHighlighted =  false, Player("Player4", 4)))
      case "c" =>
        controller.getCurrentPlayer
      case "np" =>
        controller.nextTurn()
      case "cp" =>
        controller.currentPlayerVector()
      case _ => input.toList.filter(c => c != ' ').filter(_.isDigit).map(c => c.toString.toInt) match {
          case row :: column :: Nil => controller.select(row,column)

          /**if isHighlighted == false {
            *  controller.select
            *  } else {
            *  controller.fight
            *
            */
          //controller.fight(row,column,Cell(4,4))
          //case row :: column :: value :: Nil => controller.set(row, column, Cell(value,value,"V"))
          case _ => println("unknown command")
      }
    }
  }

  override def update: Unit = {
    println(controller.fieldToString)
    println(GameStatus.message(controller.gameStatus))
  }
}
