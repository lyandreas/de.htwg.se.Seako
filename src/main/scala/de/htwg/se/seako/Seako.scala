package de.htwg.se.seako

import de.htwg.se.seako.aview.Tui
import de.htwg.se.seako.model.{Field, FieldCreator, Player, Cell}
object Seako {

  var field = new Field[Cell](3,Cell(0))
  var tui = new Tui
  def main(args: Array[String]): Unit = {
    val projectName = "Seako"
    println(projectName)

    var input : String = ""

    do {
      println("Field : " + field.toString)
      input = readLine()
      field = tui.newGame(input, field)
    } while (input != "q")
  }
}