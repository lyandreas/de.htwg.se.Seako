package de.htwg.se.seako.model

import scala.math.sqrt

case class Field[T](rows:Vector[Vector[T]]) {

  def this(size:Int, filling:T) = this(Vector.tabulate(size, size) { (row, col ) => filling})

  val size:Int = rows.size
  val blocknum: Int = sqrt(size).toInt

  def cell(row:Int, col:Int):T = rows(row)(col)

  def fill(filling:T) :Field[T] = copy(Vector.tabulate(size, size){ (row, col ) => filling})

  def replaceCell(row:Int, col:Int, cell:T):Field[T] = copy(rows.updated(row, rows(row).updated(col, cell)))

  override def toString: String = {

    var output = ""
    /*
    for {
      row <- 0 until size
      col <- 0 until size
    } output = "\n test" + output + cell(row,col).toString + " asdf"
    output



    for {
      row <- 0 until size
    }  for {
      col <- 0 until size
    } output = "test" + output + cell(row,col).toString + " asdf"
    output


     */
    for (row <- 0 until size) {
      output = "\n asdf" + output
      for (col <- 0 until size) {
        output = output + cell(row,col).toString
      }

    }
    output
    /*
    val lineseparator = ("+-" + ("--" * blocknum)) * blocknum + "+\n"
    val line = ("| " + ("x " * blocknum)) * blocknum + "|\n"
    var box = "\n" + (lineseparator + (line * blocknum)) * blocknum + lineseparator
    for {
      row <- 0 until size
      col <- 0 until size
    } box = box.replaceFirst("x", cell(row, col).toString)
    box

     */
  }

}
