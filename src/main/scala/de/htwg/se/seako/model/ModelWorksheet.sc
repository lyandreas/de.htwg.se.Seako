case class Cell(isSet: Int)

val cell1 = Cell(0)
cell1.isSet

case class Field(cells: Array[Cell])

val rows = 5
val colums = 5

val a = Array.ofDim[Cell](rows, colums)
a(0)(0) = Cell(1)
a(1)(3) = Cell(6)
a(4)(1) = Cell(5)

//the Test doesnt work

a(0)(1) = Cell(0)
a(1)(2) = Cell(2)

//The brach should develope from the testing branch
