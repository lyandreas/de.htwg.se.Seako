package de.htwg.se.seako.model

import org.scalatest.{WordSpec, Matchers}

class CellSpec extends WordSpec with Matchers{

    "A Cell " when {

      "not set to any value" should {
        val emptyCell = Cell(0)
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