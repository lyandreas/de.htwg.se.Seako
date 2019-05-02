package de.htwg.se.seako.model

import org.scalatest.{Matchers, WordSpec}

import scala.runtime.Nothing$

class CellSpec extends WordSpec with Matchers{

    "A Cell " when {

      /*
      "not set to any value" should {
        val emptyCell = Cell
        "have value 0" in {
          emptyCell.value should be(0)
        }
        "not be set" in{
          emptyCell.isSet should be (false)
        }
        "not be set by Player" in{
          emptyCell.isSetBy should be (0)
        }
      }
      */
      "not set to any Player" should {
        val emptyCell = Cell(1, Player(null))
        "have value 1" in {
          emptyCell.value should be (1)
        }
        "have player None" in {
          emptyCell.search(Player("None")) should be (None)
        }
        ""
      }

      "set to a specific value" should {
        val nonEmptyCell = Cell(1)
        "have value 1" in {
          nonEmptyCell.value should be (1)
        }
        "should be set" in {
          nonEmptyCell.isSet should be (true)
        }
        "be set by Player 1" in {
          nonEmptyCell.isSetBy should be (1)
        }
      }
    }

}