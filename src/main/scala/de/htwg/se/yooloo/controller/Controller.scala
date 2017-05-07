package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.util.Observable

/**
  * Created by svenb on 27.04.2017.
  */
class Controller(playingField: PlayingField) extends Observable {

  def playingFieldToString = playingField.toString() //TODO: toString von PlayingFiel und von Player schick überschreiben

  def initPlayer(input: String): Unit = {
    playingField.listPlayer = new Player(input) :: playingField.listPlayer //TODO: mit copy lösen, derzeit ist listPlayer in PlayingField eine var!!!

    //set current player after initial input
    if(playingField.listPlayer.length==1){setCurrentPlayer(playingField.listPlayer(0))}

    notifyObservers
  }

  def getCurrentPlayer: Player = playingField.currentPlayer

  def setCurrentPlayer(player: Player): Unit = playingField.currentPlayer = player


  def checkCardSet(input: Int): Boolean = {
    if (getCurrentPlayer.cards.cardSet.contains(input) || getCurrentPlayer.cards.cardSet.length >= 11){
       return false
    }
    true
  }

def changeCurrentPlayer: Unit={
  val myIndex = playingField.listPlayer.indexOf(getCurrentPlayer)
  if (getCurrentPlayer.cards.cardSet.length >= 10 && myIndex>=1) {

    if(myIndex <= playingField.listPlayer.length) setCurrentPlayer(playingField.listPlayer(myIndex-1))

  }
}

  def addCard(input: String): Unit = {

    //check whether there is a change of current player since cardset is completely sorted
    changeCurrentPlayer

    //add to CardSet
    if (checkCardSet(input.toInt)) {
      getCurrentPlayer.cards.cardSet = input.toInt :: getCurrentPlayer.cards.cardSet
    }

    notifyObservers

  }

  //TODO: ÄNDERN!!!!

/*  def makeAMove: Unit = {
    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    playingField.listPlayer.head.cards.sortCardSet

    playingField.listPlayer.foreach((player: Player) => if (player != playingField.listPlayer.head) player.cards.sortCardSetAutomatically)

    playingField.evaluatePoints()

    playingField.listPlayer.foreach((player: Player) => player.pointsForOneRound = 0)
    //Tui.endOfRound()

    notifyObservers
  }
*/

}
