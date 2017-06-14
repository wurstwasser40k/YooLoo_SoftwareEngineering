package de.htwg.se.yooloo.model

case class Player(namePlayer: String, cards: Cards, pointsForOneRound: Int, totalPoints: Int) {

  //creating player
  def this(name: String) = this(name, null, 0, 0)

  //creating cards
  def this(name: String, cards: Cards, tP:Int) = this(name, cards, 0, tP)

  //new Round
  def this(name: String, totalPoint: Int) = this(name, null, 0, totalPoint)


  def addPoints(points: Int, total:Int): Player = {
    val tmpPlayer = Player(this.namePlayer, this.cards, points, total)
    tmpPlayer
  }

  override def toString: String = {
    val myString = "Name: " + namePlayer
    myString
  }
}