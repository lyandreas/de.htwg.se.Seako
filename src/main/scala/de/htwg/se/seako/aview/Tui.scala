package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,FieldCreator}

class Tui {

  def players(): Unit = {
    var playercount = 0
    print("How many players [2|3|4]")
    val input = readLine()
    input match {
      case "2" => playercount = 2
      case "3" => playercount = 3
      case "4" => playercount = 4
    }
  }


  def Input(input: String, field:Field):Field = {
    input match {
      case "new" => new Field(9)



    }
  }


  def exit() {
    print("Quit Game [no|yes]")
    val input = readLine()
    input match {
      case "yes" => System.exit(0)
      case "no" => return
    }
  }
}
