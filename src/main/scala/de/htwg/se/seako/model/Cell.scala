package de.htwg.se.seako.model


case class Cell(value: Int = 1,
                isHighlighted: Boolean = false,
                player : Player = Player("Computer")
               ) {
  override def toString: String = {
    var output = ""
    player.name match {
      case "Player1" =>
        if (isHighlighted) {
          output += "HG" + value.toString
        } else {
          output += "G" + value.toString
        }
        output
      case "Player2" =>
        if (isHighlighted) {
          output += "HR" + value.toString
        } else {
          output += "R" + value.toString
        }
        output
      case "Player3" =>
        if (isHighlighted) {
          output += "HB" + value.toString
        } else {
          output += "B" + value.toString
        }
        output
      case "Player4" =>
        if (isHighlighted) {
          output += "HY" + value.toString
        } else {
          output += "Y" + value.toString
        }
        output
      case "Computer"=>
        if (isHighlighted) {
          output += "HW"+ value.toString
        } else {
          output += "W" + "," + value.toString
        }
        output
    }

  }
}