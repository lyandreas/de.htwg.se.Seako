package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,FieldCreator}

class Tui {

  def players(): Unit = {
    var numberOfPlayers = 0
    print("How many players [2|3|4]")
    val input = readLine()
    input match {
      case "2" => numberOfPlayers = 2
      case "3" => numberOfPlayers = 3
      case "4" => numberOfPlayers = 4
    }
  }


  def newGame(input: String, field:Field):Field = {
    print("creating a Field wit the size [litte|medium|big]")
    input match {
      case "litte" => new Field(3)
      case "medium" =>  new Field(6)
      case "big" => new Field(9)
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
