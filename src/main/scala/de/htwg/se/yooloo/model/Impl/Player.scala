package de.htwg.se.yooloo.model.Impl

import de.htwg.se.yooloo.model.IPlayer

case class Player(override val namePlayer: String, override val cards: Cards,
                  override val pointsForOneRound: Int, override val totalPoints: Int) extends IPlayer {

  //creating player
  def this(name: String) = this(name, null, 0, 0)

  //creating cards
  def this(name: String, cards: Cards, tP: Int) = this(name, cards, 0, tP)

  //new Round
  def this(name: String, totalPoint: Int) = this(name, null, 0, totalPoint)

  def addPoints(points: Int, total: Int): Player = {
    val tmpPlayer = Player(this.namePlayer, this.cards, points, total)
    tmpPlayer
  }

  override def toString: String = {
    val myString = "Name: " + namePlayer
    myString
  }
}