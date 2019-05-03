package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model._
import de.htwg.se.seako.controller.controllerComponent.Controller

object Seako {
  /*
  var field = new Field[Cell](2,Cell(0))
  var player = new Player("",0)
  var tui = new Tui
  */
  val controller = new Controller(new Field[Cell](6, Cell()))
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {

    var input: String = ""

    do {
      input = readLine()
      tui.processInputLine(input)
    } while (input != "q")
    /*
    val projectName = "Seako"

    var input : String = ""

    do {
      input = readLine()
      field = tui.fieldSize("Hello",field(0,0,Cell[]))
      //player = tui.players(input, player)
      println("Field : " + field.toString)
    } while (input != "q")*/

  }
}