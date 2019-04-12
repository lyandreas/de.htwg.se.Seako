package de.htwg.se.seako.model

import org.scalatest.{WordSpec, Matchers}

class FieldsizeSpec  extends WordSpec with Matchers{
  "A Field is the playingfield of SeaKo. A Field" when {

    "to be constructed" should {

      "be created with the length of its edges as size. Relevant are size 2, 4 and 10" in {
        val smalField = new Fieldsize()(2)
        val mediumField = new Fieldsize()(4)
        val bigField = new Fieldsize()(10)
      }

    }
  }
}
