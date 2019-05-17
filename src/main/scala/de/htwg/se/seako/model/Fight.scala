package de.htwg.se.seako.model

trait Fight {
  var dices = Vector[Int]()
  var dicesP2 = Vector[Int]()


  var winner = 0

  if (dices.head <= dicesP2.head){
    winner = 2
  }
  if (dices.head > dicesP2.head) {
    winner = 1
  }

  override def toString: String = {
    var output = ""
    winner match {
      case 1 =>
        output = "GREEN"
        output
      case 2 =>
        output = "RED"
        output

    }


  }
}
