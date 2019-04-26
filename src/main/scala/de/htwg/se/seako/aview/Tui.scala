package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,Cell,Player}

class Tui {


  def players(input: String, player: Player):Player = {
    var number = 0
    print("How many players [2|3|4]")
    val input = readLine()
    input match {
      case "2" => number = 2
      case "3" => number = 3
      case "4" => number = 4
    }
  }

  println("Choose size of playing field [little|medium|big]")

  def fieldSize(input: String, field:Field[Cell]):Field[Cell] = {

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
    }
  }
}
