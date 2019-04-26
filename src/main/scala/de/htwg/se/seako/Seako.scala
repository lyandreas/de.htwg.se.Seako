package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model.{Field, FieldCreator, Player, Solver}
object Seako {

  var field = new Field(9)
  var tui = new Tui;
  def main(args: Array[String]): Unit = {
    val projectName = "Seako"
    println(projectName)

    var input : String = ""

    do {
      println("Grid : " + field.toString)
      input = readLine()
      field = tui.Input(input, field)
    } while (input != "q")
  }
}