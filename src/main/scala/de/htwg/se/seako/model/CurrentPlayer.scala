package de.htwg.se.seako.model

import de.htwg.se.seako.model

class CurrentPlayer[T](vector: Vector[T]) {
  var playerVector: Vector[Player] = Vector(Player("Player1", 1), Player("Player2", 2))

  def add(player: Player) : Unit = playerVector = playerVector :+ player

  def nextPlayer() : Unit = {
    playerVector = playerVector.last +: playerVector
    playerVector = playerVector.dropRight(1)
  }

  def getCurrentPlayer: Player = playerVector.head

}
