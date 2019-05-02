package de.htwg.se.seako.model

case class Cell(value: Int,
                player: Player,
                color: String = "WHITE",
                isHighlighted: Boolean = false) {
  def search(something: Player): Option[Player] = {
    case Some(Player) => player
    case None => println("found nothing")
  }
}