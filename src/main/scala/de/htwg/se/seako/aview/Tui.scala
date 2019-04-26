package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field}

class Tui {

  def Input(input: String, field:Field):Field = {
    input match {
      case "q" =>
      case "new" => new Field(6)



    }
  }

}
