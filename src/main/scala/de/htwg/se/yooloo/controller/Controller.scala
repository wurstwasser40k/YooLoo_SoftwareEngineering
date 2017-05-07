package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.util.Observable

/**
  * Created by svenb on 27.04.2017.
  */
class Controller(playingField: PlayingField) extends Observable {


  def playingFieldToString = playingField.toString() //TODO: toString von PlayingFiel und von Player schick überschreiben

  def initPlayer(input: String): Unit = {
    playingField.listPlayer = new Player(input, playingField.numCards) :: playingField.listPlayer //TODO: mit copy lösen, derzeit ist listPlayer in PlayingField eine var!!!

    //set current player after initial input
    if (playingField.listPlayer.length == 1) {
      setCurrentPlayer(playingField.listPlayer(0))
    }

    notifyObservers
  }

  def getCurrentPlayer: Player = playingField.currentPlayer

  def setCurrentPlayer(player: Player): Unit = playingField.currentPlayer = player


  def checkCardSet(input: Int): Boolean = {
    if (input <= 0 || input > getCurrentPlayer.cards.numCards ||
      getCurrentPlayer.cards.cardSet.contains(input) || getCurrentPlayer.cards.cardSet.length > getCurrentPlayer.cards.numCards) {
      return false
    }
    true
  }

  def changeCurrentPlayer: Unit = {
    val myIndex = playingField.listPlayer.indexOf(getCurrentPlayer)
    if (getCurrentPlayer.cards.cardSet.length >= getCurrentPlayer.cards.numCards && myIndex >= 1) {

      if (myIndex <= playingField.listPlayer.length) setCurrentPlayer(playingField.listPlayer(myIndex - 1))

    }
  }

  def addCard(input: Int): Unit = {

    //check whether there is a change of current player since cardset is completely sorted
    changeCurrentPlayer

    //add to CardSet
    if (checkCardSet(input)) {
      getCurrentPlayer.cards.cardSet = input :: getCurrentPlayer.cards.cardSet
    }

    notifyObservers
  }

  def evaluatePoints(i:Int): Unit = {


   // val cardSetLength: Int = playingField.listPlayer.head.cards.cardSet.length







      playingField.pointsInThePot = playingField.pointsInThePot + playingField.pointValue
      playingField.decideWhoGetsThePoint(playingField.pointsInThePot, i)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      playingField.pointValue = playingField.pointValue + 1

      notifyObservers


    if(i+1==playingField.numCards) playingField.finishedRound = true

  }

  def checkIfRoundFinished: Boolean = {
    if (playingField.finishedRound) {
//TODO: Hier mitteilung darüber wer gewonnen hat, evtl. zweite update-Funktion????
      return true
    }
    false
  }


  def checkFullCardSet(): Boolean = {
    if (playingField.listPlayer.head.cards.cardSet.length == getCurrentPlayer.cards.numCards) {
      return true
    }
    false
  }



}
