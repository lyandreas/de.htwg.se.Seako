package de.htwg.se.seako.model

import Console.{GREEN,RED,BLUE,YELLOW_B,RESET}

case class Cell(value: Int = 1,
                playerNo: Int = 0,
                color: String = "WHITE",
                isHighlighted: Boolean = false) {
  override def toString: String = {
    var output = ""
    playerNo match {
      case 1 =>
        if (isHighlighted) {
          output += Console.BLUE + value.toString
        } else {
          output += Console.CYAN + value.toString
        }
        output
      case 2 =>
        if (isHighlighted) {
          output += Console.RED + value.toString
        } else {
          output += Console.YELLOW + value.toString
        }
        output
      case 3 =>
        if (isHighlighted) {
          output += Console.GREEN + value.toString
        } else {
          output += Console.GREEN_B + value.toString
        }
        output
      case 4 =>
        if (isHighlighted) {
          output += Console.YELLOW + value.toString
        } else {
          output += Console.YELLOW_B + value.toString
        }
        output
    }

  }
}