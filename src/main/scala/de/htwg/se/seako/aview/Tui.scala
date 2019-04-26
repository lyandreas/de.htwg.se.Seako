package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,FieldCreator,Cell}

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

  println("Choose size of playing field [little|medium|big]")
  def newGame(input: String, field:Field[Cell]):Field[Cell] = {
  //  print("creating a Field wit the size [little|medium|big]")
    input match {
      case "little" => new Field[Cell](3, Cell(0))
      case "medium" =>  new Field[Cell](6,Cell(0))
      case "big" => new Field[Cell](9,Cell(0))
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
