package de.htwg.se.seako.model


class FieldCreator {

  def players(input: String, player: Player) = {
    val numberOfPlayers = 0
    val playerOne = Player(name = "Player1", number = 1)
    val playerTwo = Player(name = "Player2", number = 2)
    val playerThree = Player(name = "Player3", number = 3)
    val playerFour = Player(name = "Player4", number = 4)

    var allPlayers = ""

    if (numberOfPlayers == 2) {
      allPlayers = playerOne.name + ", " + playerTwo.name
    }

    if (numberOfPlayers == 3) {
      allPlayers = allPlayers + " und " + playerThree.name
    } else {
      allPlayers = allPlayers + ", " + playerThree.name
    }

    if (numberOfPlayers == 4) {
      allPlayers = allPlayers + " und " + playerFour.name
    }

    println(allPlayers)

  }

}
