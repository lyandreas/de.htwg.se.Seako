package de.htwg.se.seako.model

//import main.scala.de.htwg.se.seako.model.Field
import org.scalatest.{Matchers, WordSpec}

class FieldSpec extends WordSpec with Matchers{
    "A Field is a immutable data type that contains a two-dimensional Vector of Cells. A Field" when {
      "empty" should {
        "be created by using a dimension and a sample cell" in {
          val field = new Field[Cell](2, Cell(0))
          field.cell(1,0) should be(Cell(0))
          field.cell(0,0) should be(Cell(0))
          field.cell(0,1) should be(Cell(0))
          field.cell(1,1) should be(Cell(0))
          field.size should be (2)
        }
        "but in praxis it only can be created with a vector of vectors" in {
          val testField = Field(Vector(Vector(Cell(0))))
          testField.size should be(1)
        }
        "filled" should {
          val field = new Field[Cell](2, Cell(3))
          "give access to its cells" in {
            field.cell(0, 0) should be (Cell(3))
            field.cell(0, 1) should be (Cell(3))
            field.cell(1, 0) should be (Cell(3))
            field.cell(1, 1) should be (Cell(3))
          }
          "replace cells and return a new data structure" in {
            val returnedField = field.replaceCell(0, 0, Cell(1))
            field.cell(0,0) should be (Cell(3))
            returnedField.cell(0,0) should be(Cell(1))
          }
          "be filled using fill operation" in {
            val returnedfield = field.fill(Cell(2))
            returnedfield.cell(0,0) should be (Cell(2))
          }
        }
      }
      "empty without any Cells" should {
        "be created by using no dimension and no cells" in {
          val noCellsField = new Field[Cell](0,Cell())
          noCellsField.toString() should be ("\n")
        }
      }
    }

}
