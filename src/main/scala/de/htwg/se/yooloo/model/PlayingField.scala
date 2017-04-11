package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
case class PlayingField (playerList: List[Player] ) {

  def makeAMove: Unit = {
    //TODO: Implement Method
    //calls method addPoints()
    //the class has to know how many points are in the pot
  }

  def playOneRound: Unit = {
    //TODO: Ruft zehn mal über eine for/foreach die Methode makeAMove() auf
  }
}
