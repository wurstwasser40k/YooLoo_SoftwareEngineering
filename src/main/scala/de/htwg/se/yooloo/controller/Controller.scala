package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.util.Observable

/**
  * Created by svenb on 27.04.2017.
  * Hier muss rein: Spieleranzahl und Kartenmenge
  */
class Controller(playingField: PlayingField) extends Observable {


  def playingFieldToString = playingField.toString() //TODO: toString von PlayingFiel und von Player schick überschreiben


  def initPlayer(input: String): Unit = {
    val player = Player(input)
    playingField.listPlayer = playingField.listPlayer.::(player) //TODO: mit copy lösen, derzeit ist listPlayer in PlayingField eine var!!!

    notifyObservers
  }


  def getCurrentPlayer: Player = {
    playingField.currentPlayer
  }

  def setCurrentPlayer(player: Player): Unit = {
    playingField.currentPlayer = player
  }


  //TODO: Darf keine doppleten Karten geben, und muss zwischen 1 und 10 sein
  def checkCardSet: Boolean = {
    true
  }


  def addCard(input: String): Unit = {

    if (checkCardSet) {
      getCurrentPlayer.cards.addToCardset(input.toInt)
    }

    notifyObservers

    //if the cardset ist full --> change the player
    if (getCurrentPlayer.cards.cardSet.length >= 10) {
      val myIndex = playingField.listPlayer.indexOf(getCurrentPlayer)
      setCurrentPlayer(playingField.listPlayer(myIndex + 1))
    }

  }


  /*
    def addToCardset(input: Int) {

    //if wrong userinput
    if (input <= 0 || input >= 11 || cardSet.contains(input) == true) {
      println("Wrong User-Input: Card has to be between 1-10, or the card you wanted to add is already " +
        " is already inside your cardset -> Choose another card!")

    } else {
      cardSet = input :: cardSet
      println("Your current cardSet: " + cardSet)
      if (cardSet.length <= 8) {
        println("Which card do you want to put next?")
      }
    }
  }

   */

  //TODO: ÄNDERN!!!!
  def makeAMove: Unit = {
    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    playingField.listPlayer.head.cards.sortCardSet

    playingField.listPlayer.foreach((player: Player) => if (player != playingField.listPlayer.head) player.cards.sortCardSetAutomatically)

    playingField.evaluatePoints()

    playingField.listPlayer.foreach((player: Player) => player.pointsForOneRound = 0)
    //Tui.endOfRound()

    notifyObservers
  }


}
