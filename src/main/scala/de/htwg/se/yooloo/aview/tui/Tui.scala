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
  /*
  1. Name des Spielers einfügen                               -> any String, mehr als zwei Zeichen
  2. Fertig mit Spieler einfügen                              -> f
  3. cards des jeweiligen Spielers füllen                     -> Int zwischen 1 - 9
  4. nächster Spieler füllt seine cards                       -> c
  5. Punkte evaluieren (aktueller Stand, Gesamter Stand)      -> e
  6. Neues Spiel                                              -> n
  7. quit                                                     -> q
   */

  def processInputLine(input: String): Unit = {

    input match {
      case a if input.length > 1 => controller.addPlayer(input)
      case "f" => println("Players are now ready to play.")
        controller setCurrentPlayer()
      case "c" => controller.changeCurrentPlayer()
      case "e" => controller.evaluatePoints()
      case "n" => //controller.newRoundStarted
      case "q" => println("Thank you for playing.")
      case cards if input.toInt > 0 && input.toInt < 11 => //adding name current Player
        controller.insertCards(input.toInt)
    }
  }

  /*
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

    e match {
      case GameStartedEvent => println("Welcome to HTWG Yooloo! - please enter names of Player")
      case CreatedPlayerEvent => println(playerCreationToString)
      case CurrentPlayerEvent => println("Current player is: " + controller.currentNamePlayer)
      case FullCardSetEvent => println("No more cards to add. Change player or start playing")
      case CardAddedEvent => println(
        "Player " + controller.currentNamePlayer + " has the following cards: "
          + controller.players(controller.indexCurrentPlayer).cards.toString)


      case MoveEvaluatedEvent => println(evaluateMoveToString)
      case RoundEvaluated => println(playingFieldToString)
      // case _ => println(controller.playingFieldToString)
    }
  }

  def playerCreationToString: String = {
    var myString: String = ""
    controller.players.foreach((player: Player) => myString = myString + player.toString + " ") + ""
    myString
  }

  def evaluateMoveToString: String = {
    var myString: String = "Uncovered Cards of each Player "
    controller.players.foreach((player: Player) => myString = myString + player.cards.cards(controller.i) + " ")
    myString = myString + " -> current points for each player: "
    controller.players.foreach((player: Player) => myString = myString + player.pointsForOneRound + " ")

    myString
  }

  def playingFieldToString: String = {
    var myOutput = ""
    controller.players.foreach((player: Player) => myOutput = myOutput + "PlayerName: " + player.namePlayer + " has Cardset: " + player.cards.cards
      + ",pointsForOneRound: " + player.pointsForOneRound + ",totalPoints: " + player.totalPoints + "\n")
    myOutput
  }
}
