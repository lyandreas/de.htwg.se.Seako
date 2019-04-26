package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,FieldCreator}

class Tui {

  def players


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
