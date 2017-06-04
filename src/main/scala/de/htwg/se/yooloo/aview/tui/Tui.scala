package de.htwg.se.yooloo.aview.tui

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.model.Player
import de.htwg.se.yooloo.util._

/**
  * ***** Info ****
  * Tui is the concrete subject and has to implement Controller.update()
  * Observable.update() obtains state information from the subject and acts on that state
  * ****  Info ****
  */

class Tui(controller: Controller) extends Observer {

  controller.add(this)

  def enterplayerNames(input: String) {
    input match {
      case "f" => println("Players are now ready to play.")
      case _ => controller.addPlayer(input)
    }
  }
  /*
   def enterCard(input: String): Unit = {
     try {
       var myInput: Int = input.toInt
       controller.setNameCurrentPlayer()
       controller.addCard(myInput)
     } catch {
       case e: NumberFormatException => println("Please enter a number")
     }

   }


   def pressEnter(i: Int): Unit = {controller.evaluatePoints(i: Int)}


   def continueOrQuit(input: String): Unit = {
     input match {
       case "y" => println("Next round starts now")
         controller.newRoundStarted()
       case _ => println("Thanks for playing")
     }
   }
   */

  override def update(e: Event): Unit = {

    //   println(controller.playingFieldToString)

    e match {
      case GameStartedEvent => println("Welcome to HTWG Yooloo! - please enter names of Player")
      case CreatedPlayerEvent => println(playerCreationToString)
      // case CardAddedEvent => println(controller.cardAddedToString)
      // case MoveEvaluatedEvent => println(controller.evaluateMoveToString)
      // case RoundEvaluated => println(controller.playingFieldToString)


      //case _ => println(controller.playingFieldToString)
    }

  }

  def playerCreationToString: String = {
    var myString: String = ""
    controller.players.foreach((player: Player) => myString = myString + player.toString + " ") + ""
    myString
  }

  /*
    TODO: einpflegen, kommt aus PlayingField!
     override def toString: String = {
      var myOutput = ""

      listPlayer.foreach((player: Player) => myOutput = myOutput + "PlayerName: " + player.namePlayer + " has Cardset: " + player.cards.cards
        + ",pointsForOneRound: " + player.pointsForOneRound + ",totalPoints: " + player.totalPoints + "\n")
      myOutput
    }



    def cardAddedToString = "Player " + currentPlayer.namePlayer + " has the following cards: " + currentPlayer.cards.toString

    def evaluateMoveToString = {
      var myString: String = "Uncovered Cards of each Player "
      listPlayer.foreach((player: Player) => myString = myString + player.cards.cards(this.i) + " ")
      myString = myString + " -> current points for each player: "
      listPlayer.foreach((player: Player) => myString = myString + player.pointsForOneRound + " ")

      myString
    }
     */
}
