package de.htwg.se.seako.controller.controllerComponent

import java.util.concurrent.Flow.Publisher

import de.htwg.se.seako.controller.controllerComponent.GameStatus.GameStatus
import de.htwg.se.seako.model.gridComponent.{CellInterface, GridInterface}

import scala.swing.Publisher

trait ControllerInterface extends Publisher {
  def gridSize: Int

  def blockSize: Int

  def createEmptyGrid: Unit

  def createNewGrid: Unit

  def undo: Unit

  def redo: Unit

  def solve: Unit

  def save: Unit

  def load: Unit

  def resize(newSize: Int): Unit

  def cell(row: Int, col: Int): CellInterface

  def set(row: Int, col: Int, value: Int): Unit

  def isSet(row: Int, col: Int): Boolean

  def isGiven(row: Int, col: Int): Boolean

  def showCandidates(row: Int, col: Int): Unit

  def highlight(index: Int): Unit

  def isHighlighted(row: Int, col: Int): Boolean

  def gridToString: String

  def isShowCandidates(row: Int, col: Int): Boolean

  def toggleShowAllCandidates: Unit

  def showAllCandidates: Boolean

  def available(row: Int, col: Int): Set[Int]

  def gameStatus: GameStatus

  def statusText: String

  def gridToJson: JsValue

  def finish(): Unit
}

trait ControllerIoInterface {

  def setGiven(row: Int, col: Int, value: Int)
  def setShowCandidates(row: Int, col: Int)
