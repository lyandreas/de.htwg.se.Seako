package de.htwg.se.seako.model

case class Cell(value: Int = 1,
                player:  Player = Player("None"),
                color: String = "WHITE",
                isHighlighted: Boolean = false) {
  def search(something: Player): Option[Player] = {
    case Some(Player) => player
    case None => println("found nothing")
  }
  def isSetByPlayer() : Option[Player] = {
    case Some(Player) => player
    case None => false
  }
}