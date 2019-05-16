package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model._
import de.htwg.se.seako.controller.controllerComponent.Controller

object Seako {

  val controller = new Controller(new Field[Cell](6, Cell()), new CurrentPlayer[Player](Vector(Player("Player1",1), Player("Player2",2)) ))
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = ""
    if (args.length > 0) input = args(0)
    if(!input.isEmpty) tui.processInputLine(input)
    else do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")

  }
}