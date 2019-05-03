package de.htwg.se.seako.model

case class Cell(value: Int = 1,
                playerNo: Int = 0,
                color: String = "WHITE",
                isHighlighted: Boolean = false) {
}