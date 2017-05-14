package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.util._

/**
  * Created by svenb on 27.04.2017.
  */
class Controller(playingField: PlayingField) extends Observable {



  def playingFieldToString :String = playingField.toString()
  def playerCreationToString :String = playingField.playerCreationToString
  def cardAddedToString :String =  playingField.cardAddedToString
  def evaluateMoveToString: String= playingField.evaluateMoveToString



  def initPlayer(input: String): Unit = {
    playingField.listPlayer = new Player(input, playingField.numCards) :: playingField.listPlayer //TODO: mit copy lösen, derzeit ist listPlayer in PlayingField eine var!!!

    //set current player after initial input
    if (playingField.listPlayer.length == 1) {
      currentPlayer_=(playingField.listPlayer(0))
    }


    notifyObservers(CreatedPlayerEvent)
  }

  def currentPlayer: Player = playingField.currentPlayer

  def currentPlayer_=(player: Player): Unit = playingField.currentPlayer = player


  def checkCardSet(input: Int): Boolean = {
    if (input <= 0 || input > currentPlayer.cards.numCards ||
      currentPlayer.cards.cardSet.contains(input) || currentPlayer.cards.cardSet.length > currentPlayer.cards.numCards) {
      return false
    }
    true
  }

  def changeCurrentPlayer: Unit = {
    val myIndex = playingField.listPlayer.indexOf(currentPlayer)
    if (currentPlayer.cards.cardSet.length >= currentPlayer.cards.numCards && myIndex >= 1) {

      if (myIndex <= playingField.listPlayer.length) currentPlayer_=(playingField.listPlayer(myIndex - 1))

    }
  }


  def newRoundStarted():Unit={

    playingField.listPlayer.foreach((player: Player) => {
      player.cards.cardSet=Nil
      player.pointsForOneRound=0
    }
    )
    currentPlayer_=(playingField.listPlayer(playingField.listPlayer.length-1))
    playingField.pointValue=1
    playingField.finishedRound=false

  }



  def addCard(input: Int): Unit = {

    //check whether there is a change of current player since cardset is completely sorted
    changeCurrentPlayer

    //add to CardSet
    if (checkCardSet(input)) {
      currentPlayer.cards.cardSet = input :: currentPlayer.cards.cardSet
    }


    notifyObservers(CardAddedEvent)
  }

  def evaluatePoints(i:Int): Unit = {
      playingField.i=i
      playingField.pointsInThePot = playingField.pointsInThePot + playingField.pointValue
      playingField.decideWhoGetsThePoint(playingField.pointsInThePot, i)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      playingField.pointValue = playingField.pointValue + 1

      notifyObservers(MoveEvaluatedEvent)



    if(i+1==playingField.numCards) {
      playingField.finishedRound = true
      notifyObservers(RoundEvaluated)}

  }

  def checkIfRoundFinished: Boolean = {
    if (playingField.finishedRound) {
//TODO: Hier mitteilung darüber wer gewonnen hat, evtl. zweite update-Funktion????
      return true
    }
    false
  }


  def checkFullCardSet(): Boolean = {
    if (playingField.listPlayer.head.cards.cardSet.length == currentPlayer.cards.numCards) {
      return true
    }
    false
  }



}
