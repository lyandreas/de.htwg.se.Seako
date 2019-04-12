package de.htwg.se.seako.model

import javafx.scene.transform.MatrixType

case class Field(fieldsize: Matrix[Cell]) {
  def this(size:Int) = this(new Matrix[Cell](size, Cell(0)))
  val size:Int = fieldsize.size
  def cell(row:Int, col:Int):Cell = fieldsize.cell(row, col)
  def set (row:Int, col:Int, value:Int):Field = copy(fieldsize.replaceCell(row, col, Cell(Value)))
}
