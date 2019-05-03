package de.htwg.se.seako.aview

import java.io.BufferedReader;

import de.htwg.se.seako.model.{Field,Cell,Player, FieldCreator}

class Tui {
  var fieldCreator = new FieldCreator()
  var stopRunning = false

  def processInput(input : BufferedReader) = {
    while (!stopRunning) {
      if (input.ready()) {
        val line = input.readLine()
        processInput(line)
      } else {
        Thread.sleep(200)
      }
    }
  }



  def players(input: String, player: Player):Unit = {
    var number = 0
    print("How many players [2|3|4]")
    val input = readLine()
    input match {
      case "2" => number = 2
                  print("Two Players")
                  print("insert name:")
      case "3" => number = 3
      case "4" => number = 4
    }
  }

  println("Choose size of playing field [little|medium|big]")

  def fieldSize(input: String, field:Field[Cell]):Unit = {

    input match {
      case "little" => new Field[Cell](3, Cell(0))
      case "medium" => fieldCreator.size = 6
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
