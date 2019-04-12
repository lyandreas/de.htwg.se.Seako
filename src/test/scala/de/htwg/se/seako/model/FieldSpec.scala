package de.htwg.se.seako.model

class FieldSpec {
  "A Field is the playingfield of SeaKo. A Field" when {

    "to be constructed" should {

      "be created with the length of its edges as size. Relevant are size 2, 4 and 10" in {
        val smalField = new Field(2)
        val mediumField = new Field(4)
        val bigField = new Field(10)
      }

    }
  }
}
