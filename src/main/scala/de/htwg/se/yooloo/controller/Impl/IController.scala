package de.htwg.se.yooloo.controller.Impl

trait IController {

  def addPlayer(input: String): Unit

  def setCurrentPlayer(): Unit

  def changeCurrentPlayer(): Unit

  def insertCards(input: Int): Unit

  def addCard(input: Int): Unit

  def newRoundStarted(): Unit
}
