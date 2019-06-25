package de.htwg.se.seako.model

case class Player(var name: String, number: Int) {
  override def toString: String = name
  def getNumber: Int = number

}