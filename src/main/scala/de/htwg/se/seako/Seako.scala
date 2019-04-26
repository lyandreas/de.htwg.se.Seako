package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model.{Field, FieldCreator, Player,Cell}
object Seako {

  var field = new Field[Cell](2,Cell(0))
  var tui = new Tui;
  def main(args: Array[String]): Unit = {
    val projectName = "Seako"
    println(projectName)

    var input : String = ""

    do {
      input = readLine()
      field = tui.newGame(input, field)
      println("Field : " + field.toString)
    } while (input != "q")
  }
}