package de.htwg.se.seako.model


case class Cell(value: Int = 1,
                playerNo: Int = 0,
                color: String = "W",
                isHighlighted: Boolean = false,
                player: Player = Player("Computer", 0)
               ) {

  override def toString: String = {
    var output = ""
    playerNo match {
      case 1 =>
        if (isHighlighted) {
          output += "l" + color + "," + value.toString
        } else {
          output += color + "," + value.toString
        }
        output
      case 2 =>
        if (isHighlighted) {
          output += "l" + color + "," + value.toString
        } else {
          output += color + "," + value.toString
        }
        output
      case 3 =>
        if (isHighlighted) {
          output += "l" + color + "," + value.toString
        } else {
          output += color + "," + value.toString
        }
        output
      case 4 =>
        if (isHighlighted) {
          output += "l" + color + "," + value.toString
        } else {
          output += color + "," + value.toString
        }
        output
      case 0 =>
        if (isHighlighted) {
          output += color + "," + value.toString
        } else {
          output += color + "," + value.toString
        }
        output
    }

  }
}