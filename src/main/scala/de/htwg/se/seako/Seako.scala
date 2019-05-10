package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model._
import de.htwg.se.seako.controller.controllerComponent.Controller

object Seako {

  val controller = new Controller(new Field[Cell](6, Cell()))
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = args(0)
    if(!input.isEmpty) tui.processInputLine(input)
    else do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")

  }
}