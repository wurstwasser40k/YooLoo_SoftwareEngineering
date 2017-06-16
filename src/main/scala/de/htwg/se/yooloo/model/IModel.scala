package de.htwg.se.yooloo.model

import de.htwg.se.yooloo.model.Impl.{Cards, Player}

trait IPlayer {

  val namePlayer: String
  val cards: ICards
  val pointsForOneRound: Int
  val totalPoints: Int

  def addPoints(points: Int, total: Int): Player
}

trait ICards {

  val cards: List[Int]

  def addCard(input: Int): Cards
}