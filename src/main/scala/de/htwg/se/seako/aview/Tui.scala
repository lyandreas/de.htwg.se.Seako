package de.htwg.se.seako.aview

import java.io.BufferedReader;
import de.htwg.se.seako.controller.controllerComponent.Controller

class Tui(controller: Controller) {

  def processInput(input : String) = {
    input match {
      case "quit" => controller.finish()
      case "new" => controller.createEmptyField()
      case "2" => controller.
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

  def fieldSize(input: String, field:Field[Cell]):Field[Cell] = {

    input match {
      case "little" =>  fieldsize = 3
      case "medium" =>  new Field[Cell](6,Cell(0))
      case "big" => new Field[Cell](9,Cell(0))
    }
  }


}
