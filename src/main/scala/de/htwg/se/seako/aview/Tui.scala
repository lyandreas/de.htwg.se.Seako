package de.htwg.se.seako.aview

import java.io.BufferedReader

import de.htwg.se.seako.controller.controllerComponent.Controller
import de.htwg.se.seako.model.{Cell, Field, Player}
import de.htwg.se.seako.util.Observer

class Tui(controller: Controller) extends Observer {
  controller.add(this)
  var size = 6

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "n" => controller.createEmptyField(size)
      case "s-l" =>
        size = 3
        controller.createEmptyField(size)
      case "s-m" =>
        size = 6
        controller.createEmptyField(size)
      case "s-b" =>
        size = 9
        controller.createEmptyField(size)
      case "p2" =>
        controller.set(0,0,Cell(1,1,"G"))
        controller.set(size-1, size-1,Cell(1,2,"R"))
      case "p3" =>
        controller.set(0,0,Cell(1,1,"G"))
        controller.set(size-1,size-1,Cell(1,2,"R"))
        controller.set(0,size-1,Cell(1,3,"B"))
      case "p4" =>
        controller.set(0,0,Cell(1,1,"G"))
        controller.set(size-1,size-1,Cell(1,2,"R"))
        controller.set(0,size-1,Cell(1,3,"B"))
        controller.set(size-1,0,Cell(1,4,"Y"))
      case "c" =>
        controller.getCurrentPlayer()
      case "np" =>
        controller.nextTurn()
      case _ =>
        println("unknown command")
    }
  }

  override def update: Unit = println(controller.fieldToString)
}
