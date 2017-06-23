package de.htwg.se.yooloo.aview.tui

import de.htwg.se.yooloo.controller._
import de.htwg.se.yooloo.controller.Impl._
import de.htwg.se.yooloo.model.IPlayer

import scala.swing.Reactor

/**
  * ***** Info ****
  * Tui is the concrete subject and has to implement Controller.update()
  * Observable.update() obtains state information from the subject and acts on that state
  * ****  Info ****
  */

class Tui(controller: Controller) extends Reactor {


  listenTo(controller)

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
                  controller.setCurrentPlayer()


      case "c" => controller.changeCurrentPlayer()
      case "e" => controller.evaluatePoints()
      case "n" => controller.newRoundStarted
      case "q" => println("Thank you for playing.")
        controller.exit()
      case cards if input.toInt > 0 && input.toInt < 11 => //adding name current Player
        controller.insertCards(input.toInt)
    }
  }


  reactions += {
    case e:GameStartedEvent => println("Welcome to HTWG Yooloo! - please enter names of Player")

    case e:CreatedPlayerEvent => println(playerCreationToString)

    case e:CurrentPlayerEvent => println("Current player is: " + controller.getNameCurrentPlayer)

    case e:FullCardsEvent => println("No more cards to add. Change player or start playing")

    case e:CardAddedEvent => println(
      "Player " + controller.getNameCurrentPlayer + " has the following cards: "
        + controller.getPlayers()(controller.getIndexCurrentPlayer).cards.toString)


    case e:MoveEvaluatedEvent => println(evaluateMoveToString)

    case e:RoundEvaluated => println(playingFieldToString)

    case _ => println(playingFieldToString)
  }

  def playerCreationToString: String = {
    var myString: String = ""
    controller.getPlayers.foreach((player: IPlayer) => myString = myString + player.toString + " ") + ""
    myString
  }

  def evaluateMoveToString: String = {
    var myString: String = "Uncovered Cards of each Player "
    controller.getPlayers.foreach((player: IPlayer) => myString = myString + player.cards.cards(controller.getI) + " ")
    myString = myString + " -> current points for each player: "
    controller.getPlayers.foreach((player: IPlayer) => myString = myString + player.pointsForOneRound + " ")

    myString
  }

  def playingFieldToString: String = {
    var myOutput = ""
    controller.getPlayers.foreach((player: IPlayer) => myOutput = myOutput + "PlayerName: " + player.namePlayer + " has Cards: " + player.cards
      + "pointsForOneRound: " + player.pointsForOneRound + ",totalPoints: " + player.totalPoints + "\n")
    myOutput
  }
}