package de.htwg.se.seako.model

case class Symbol(var symbol: Int) {
  override def toString: String = {
    var output = ""
    symbol match {
      case 1 => output = "Schere"
        output
      case 2 => output = "Stein"
        output
      case 3 => output = "Papier"
        output
      case _ => output = ""
        output
    }
  }

}
