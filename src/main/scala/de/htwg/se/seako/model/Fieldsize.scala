package de.htwg.se.seako.model

import main.scala.de.htwg.se.seako.model.Field

case class Fieldsize(fieldsize: Field[Cell]) {

  def this(size:Int) = this(new Field[Cell](size, Cell(0)))

  val size:Int = fieldsize.size

  def cell(row:Int, col:Int):Cell = fieldsize.cell(row, col)

  def set (row:Int, col:Int, value:Int):Fieldsize = copy(fieldsize.replaceCell(row, col, Cell(value)))
}
