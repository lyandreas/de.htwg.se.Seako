package de.htwg.se.seako.model

case class Player(var name: String) {
  override def toString: String = name
}