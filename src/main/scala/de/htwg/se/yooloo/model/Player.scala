package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
case class Player(namePlayer: String, cardSet: CardSet) {

  //Langfristige Idee: Punkte mit Liste/Vector festhalten
  var points: Int = 0
  //TODO: Ist var okay, not immutable?
  var totalPoints: Int = 0 //TODO: Ist var okay, not immutable?

  def addPoints(points: Int): Unit = {
    this.points = this.points + points
  }

}