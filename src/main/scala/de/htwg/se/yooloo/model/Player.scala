package de.htwg.se.yooloo.model

case class Player(namePlayer: String, cards: Cards, pointsForOneRound: Int, totalPoints: Int) {

  //creating player
  def this(namePlayer: String) = this(namePlayer, null, 0, 0)

  //creating cards
  def this(name: String, cards: Cards) = this(name, cards, 0, 0)

  def addPoints(points: Int): Player =
    copy(totalPoints = totalPoints + points).copy(pointsForOneRound = pointsForOneRound + points)

  override def toString: String = {
    val myString = "Name: " + namePlayer
    myString
  }
}