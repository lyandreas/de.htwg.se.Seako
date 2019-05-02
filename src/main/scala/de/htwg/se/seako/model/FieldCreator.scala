package de.htwg.se.seako.model

import de.htwg.se.seako.aview.Tui

class FieldCreator {
  var size = 0
  val field = new Field[Cell](size, Cell(0))

  var minCol = 0
  var minRow = 0
  var maxRow = field.size
  var maxCol = field.size

  def setPlayer(input: String, player: Player) = {
    val numberOfPlayers = 0
    val playerOne = Player(name = "Player1", number = 1)
    val playerTwo = Player(name = "Player2", number = 2)
    val playerThree = Player(name = "Player3", number = 3)
    val playerFour = Player(name = "Player4", number = 4)

    var allPlayers = ""

    if (numberOfPlayers == 2) {
      allPlayers = playerOne.name + ", " + playerTwo.name
      field.replaceCell(0,0,Cell(1,playerOne))
      field.replaceCell(field.size, field.size, Cell(1,playerTwo))


    }

    if (numberOfPlayers == 3) {
      allPlayers = allPlayers + " and " + playerThree.name
    } else {
      allPlayers = allPlayers + ", " + playerThree.name
    }

    if (numberOfPlayers == 4) {
      allPlayers = allPlayers + " and " + playerFour.name
    }

    println(allPlayers)

  }


}
