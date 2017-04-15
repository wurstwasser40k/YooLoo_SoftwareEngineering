package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
case class PlayingField (playerList: List[Player] ) {


  /**
    * Every player sorts his cardSet
    */
  def makeAMove(set1: CardSet, set2: CardSet,set3: CardSet): Unit = {


    println("Player 1 - sort your cardDeck")
    set1.sortCardSet

    println("Player 2 - sort your cardDeck")
    set2.sortCardSetAutomatically

    println("Player 3 - sort your cardDeck")
    set3.sortCardSetAutomatically

  //  println(set1.cardSet)



    //TODO: Implement Method
    //calls method addPoints()
    //the class has to know how many points are in the pot
  }

  def playOneRound: Unit = {
    //TODO: Ruft zehn mal über eine for/foreach die Methode makeAMove() auf
  }
}
