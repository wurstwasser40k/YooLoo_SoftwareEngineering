package de.htwg.se.yooloo.model

case class Player(namePlayer: String, cards: Cards, pointsForOneRound: Int, totalPoints: Int) {

  def addPoints(points: Int): Player = copy(totalPoints = totalPoints + points).copy(pointsForOneRound = pointsForOneRound + points)

  override def toString: String = {
    val myString = "Name: " + namePlayer
    myString
  }
}
