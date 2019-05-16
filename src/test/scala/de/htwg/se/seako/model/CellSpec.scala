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
          emptyCell.playerNo should be (0)
        }
        "color should be " in {
          emptyCell.color should be ("WHITE")
        }
        "and isHighlighted " in {
          emptyCell.isHighlighted should be (false)
        }
      }

      "set to a specific value and player" should {
        val nonEmptyCell = Cell(4,1,"GREEN")
        "have value 4" in {
          nonEmptyCell.value should be (4)
        }
        "have playerNo" in {
          nonEmptyCell.playerNo should be (1)
        }
        "color should be" in {
          nonEmptyCell.color should be ("GREEN")
        }
        "and isHighlighted " in {
          nonEmptyCell.isHighlighted should be (false)
        }
      }
    }

}