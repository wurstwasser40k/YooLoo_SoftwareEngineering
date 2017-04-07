package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
class Round {

  var roundNumber: Int = 1 //initially 1, will be increased  //TODO: var is not immutable?

  def increaseRound: Unit = {
    roundNumber = roundNumber + 1
  }

}
