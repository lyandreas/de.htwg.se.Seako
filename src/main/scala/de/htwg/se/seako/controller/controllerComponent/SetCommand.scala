package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model.Cell
import de.htwg.se.seako.util.Command

class SetCommand (row:Int, col: Int, cell: Cell, controller: Controller) extends Command{

  var tmpCell = Cell()
  override def doStep(): Unit = {
    tmpCell = controller.field.cell(row, col)
    controller.field = controller.field.replaceCell (row, col, cell)

  }
  //override def undoStep(): Unit = controller.field = controller.field.replaceCell(row, col, Cell(1,0,"W"))
  override def undoStep(): Unit = controller.field = controller.field.replaceCell(row, col, tmpCell)

  override def redoStep(): Unit = controller.field = controller.field.replaceCell(row, col, cell)

}