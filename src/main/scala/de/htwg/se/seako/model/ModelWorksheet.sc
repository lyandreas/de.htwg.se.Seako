import de.htwg.se.seako.model.Player

import scala.collection.immutable.Queue

case class Cell(isSet: Int)

val cell1 = Cell(0)
cell1.isSet

case class Field(cells: Array[Cell])

val rows = 7
val colums = 7

val a = Array.ofDim[Cell](rows, colums)
a(0)(0) = Cell(1)
a(1)(0) = Cell(0)
a(4)(1) = Cell(2)

a(2)(0) = Cell(0)
a(4)(2) = Cell(1)

a(3)(2) = Cell(3)
a(0)(1) = Cell(0)

a(5)(2) = Cell(3)
a(5)(1) = Cell(2)

a(1)(2) = Cell(3)
println("Das ist nur ein Test") // try to merge that!
println("JDK-TEST")
println("JDK-TEST Other direction")

var playerVector: Vector[Player] = Vector(Player("Player1"), Player("Player2"))

playerVector = playerVector :+ Player("Player3")

playerVector = playerVector.last +: playerVector
playerVector = playerVector.dropRight(1)
playerVector
playerVector.head