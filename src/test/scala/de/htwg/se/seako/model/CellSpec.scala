package de.htwg.se.seako.model

import org.scalatest.{Matchers, WordSpec}

import scala.runtime.Nothing$

class CellSpec extends WordSpec with Matchers{

    "A Cell " when {
      "not set to any Player" should {
        val emptyCell = Cell()
        "have value 1" in {
          emptyCell.value should be (1)
        }
        "have playerNo" in {
        }
        "and isHighlighted " in {
          emptyCell.isHighlighted should be (false)
        }
      }

      "set to a specific value and player" should {
        "and isHighlighted " in {
          //nonEmptyCell.isHighlighted should be (false)
        }
      }
    }

}