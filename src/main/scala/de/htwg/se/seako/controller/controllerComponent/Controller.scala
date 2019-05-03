package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model._
import de.htwg.se.seako.util.Observable

class Controller(var field: Field[Cell]) extends Observable{

  def createEmptyField(size: Int): Unit = {
    field = new Field[Cell](size, Cell(0))
    notifyObservers
  }

  def fieldToString: String = field.toString

  def set(row: Int, col: Int, cell: Cell): Unit = {
    field = field.replaceCell(row: Int, col: Int, cell: Cell) : Field[Cell]
    notifyObservers
  }

}
