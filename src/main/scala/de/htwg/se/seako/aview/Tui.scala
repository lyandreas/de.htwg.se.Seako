package de.htwg.se.seako.aview

import de.htwg.se.seako.model.{Field,FieldCreator}

class Tui {

  def Input(input: String, field:Field):Field = {
    input match {
      case "q" = field
      case "n" => new Field(9)
      case "start" =>

    }
  }
}
