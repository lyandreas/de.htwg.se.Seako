package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model.{Field, Player,Cell}
object Seako {

  var field = new Field[Cell](2,Cell(0))
  var player = new Player("",0)
  var tui = new Tui

  def main(args: Array[String]): Unit = {
    val projectName = "Seako"

    var input : String = ""

    do {
      input = readLine()
      field = tui.fieldSize(input, field)
      player = tui.players(input, player)
      println("Field : " + field.toString)
    } while (input != "q")
  }
}