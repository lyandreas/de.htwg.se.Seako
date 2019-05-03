package de.htwg.se.seako.aview

import java.io.BufferedReader

import de.htwg.se.seako.controller.controllerComponent.Controller
import de.htwg.se.seako.model.{Cell, Field, FieldCreator, Player}
import de.htwg.se.seako.util.Observer

class Tui(controller: Controller) extends Observer {
  controller.add(this)
  val size = 93

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "n" => controller.createEmptyField(size)
      case _ =>
    }
  }

  override def update: Unit = println(controller.fieldToString)
}
