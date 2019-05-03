package de.htwg.se.seako.aview

import org.scalatest.{Matchers, WordSpec}
import de.htwg.se.seako.controller.controllerComponent.Controller
import de.htwg.se.seako.model.{Cell, Field}

class TuiSpec extends WordSpec with Matchers {

  "A SeaKo Tui" should {
    val controller = new Controller(new Field[Cell](6, Cell(0)))
    val tui = new Tui(controller)
    "create an empty playing field with input 'n'" in {
      tui.processInputLine("n")
      controller.field should be(new Field[Cell](6, Cell(0)))
    }
    "change the size of the playing field to little with the input 's-l'" in {
      tui.processInputLine("s-l")
      controller.field should be(new Field[Cell](3, Cell(0)))
    }
    "change the size of the playing field to medium with the input 's-m'" in {
      tui.processInputLine("s-m")
      controller.field should be(new Field[Cell](6, Cell(0)))
    }
    "change the size of the playing field to big with the input 's-b'" in {
      tui.processInputLine("s-b")
      controller.field should be(new Field[Cell](9, Cell(0)))
    }
    "choose amount of players and set them on field with input'p2'" in{
      tui.processInputLine("p2")
      controller.field.cell(0,0) should be(Cell(1,1,"GREEN"))
      controller.field.cell(9,9) should be(Cell(1,2,"RED"))
    }

  }
}
