package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._

class Controller {
  val size = 0

  val field = new Field(size, Cell)
  var numbersOfPlayer = 0
  val playerOne = Player("Player 1", 1)
  val playerTwo = Player("Player 2", 2)
  val PlayerThree = Player("Player 3", 3)
  val PlayerFour = Player("Player 4", 4)

  var allPlayers = ""

  if  (numbersOfPlayer == 2) {
    allPlayers = playerOne.name + ", " + playerTwo.name
    field.replaceCell(0,0,Cell[])
    field.replaceCell(field.size, field.size, Cell(,playerTwo,,))

  }

  val row = field.size
  val col = field.size


}
