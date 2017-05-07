package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
case class Player(namePlayer: String, numCards:Int) {

  var cards = new CardSet(numCards)

  //Langfristige Idee: Punkte mit Liste/Vector festhalten
  var pointsForOneRound: Int = 0
  var totalPoints: Int = 0 //TODO: Ist var okay, not immutable?

  def addPoints(points: Int): Unit = {
    this.totalPoints = this.totalPoints + points
    this.pointsForOneRound = this.pointsForOneRound + points
  }
}
