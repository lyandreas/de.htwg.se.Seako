package de.htwg.se.seako.controller.controllerComponent

import de.htwg.se.seako.model.Cell
import de.htwg.se.seako.util.Command

class SetCommand (row:Int, col: Int, cell: Cell, controller: Controller) extends Command{

  override def doStep: Unit =   controller.field = controller.field.replaceCell(row, col, cell)

  override def undoStep: Unit = controller.field = controller.field.replaceCell(row, col, 0)

  override def redoStep: Unit = controller.field = controller.field.replaceCell(row, col, cell)

}
