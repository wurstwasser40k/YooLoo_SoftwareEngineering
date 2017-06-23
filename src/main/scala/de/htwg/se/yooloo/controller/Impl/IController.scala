package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{ICardsFactory, IPlayer, IPlayerFactory}


import scala.swing.Publisher

trait IController extends Publisher {

  var players: List[IPlayer]
  val playerFactory: IPlayerFactory
  val cardsFactory: ICardsFactory

  def getPlayers(): List[IPlayer]

  def getNameCurrentPlayer(): String

  def getIndexCurrentPlayer: Int

  def getI: Int

  def addPlayer(input: String): Unit

  def setCurrentPlayer(): Unit

  def changeCurrentPlayer(): Unit

  def insertCards(input: Int): Unit

  def addCard(input: Int): Unit

  def evaluatePoints(): Unit

  def newRoundStarted(): Unit

  def exit(): Unit
}