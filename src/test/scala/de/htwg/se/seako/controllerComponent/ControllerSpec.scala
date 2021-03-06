package de.htwg.se.seako.controllerComponent

import de.htwg.se.seako.util.Observer
import de.htwg.se.seako.controller.controllerComponent.Controller
import de.htwg.se.seako.model.{Cell, Field}
import org.scalatest.{Matchers, WordSpec}


class ControllerSpec extends WordSpec with Matchers{

  "A Controller" when {
    "observed by an Observer" should {
      val smallField = new Field[Cell](3,Cell())
      val controller = new Controller(smallField)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Unit = updated = true
      }

      controller.add(observer)
      "notify its Observer after creation" in {
        controller.createEmptyField(3)
        observer.updated should be (true)
        controller.field.size should be (3)
      }

      "notify its Observer after setting a cell to PlayerOne" in {
        controller.set(0,0,Cell(1,1,"GREEN"))
        observer.updated should be (true)
        controller.field.cell(0,0).value should be (1)
        controller.field.cell(0,0).playerNo should be (1)
        controller.field.cell(0,0).color should be ("GREEN")
        controller.field.cell(0,0).isHighlighted should be (false)
      }
    }
  }
}
