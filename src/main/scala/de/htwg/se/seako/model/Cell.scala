package de.htwg.se.seako.model

import Console.{GREEN,RED,BLUE,YELLOW_B,RESET}

case class Cell(value: Int = 1,
                playerNo: Int = 0,
                color: String = "WHITE",
                isHighlighted: Boolean = false) {
  /*override def toString: String = {
    var output = ""
    playerNo match {
      case 1 =>
        output = "${RESET}${GREEN}1${RESET}"
        output
      case 2 =>
        output = "${RESET}${RED}2${RESET}"
        output
      case 3 =>
        output = "${RESET}${BLUE}3${RESET}"
        output
      case 4 =>
        output = "${RESET}${YELLOW_B}4${RESET}"
        output
      case _ =>
        output = "-"
        output
    }

  }*/
}