package de.htwg.se.yooloo.aview.gui

import de.htwg.se.yooloo.controller.Impl.Controller
import de.htwg.se.yooloo.controller.{MoveEvaluatedEvent, RoundEvaluated}
import de.htwg.se.yooloo.model.IPlayer

import scala.swing.{Action, Button, Dialog, GridPanel}

/**
  * Created by svenb on 16.06.2017.
  *  On this surface the cards will be sorted
  */
class SortPanel(controller: Controller) extends GridPanel(1, controller.getAmountOfCards()){

  val gridHeight = 1 //alternativ setzt man es auf die Anzahl der Spieler controller.getAmountOfPlayers()
  val gridWidth = controller.getAmountOfCards()
  listenTo(controller)


  for (viewCol <- (0 until gridWidth)){
    contents += new Button(""+(viewCol+1)){
      action = Action(""+(viewCol+1)){
        controller.addCard(viewCol+1)

      //  visible=false
      }
    }
  }

  def showDialog(message: String) = Dialog.showMessage(this, message)

  reactions += {
    case e: MoveEvaluatedEvent => showDialog(evaluateMoveToString)
    case e: RoundEvaluated => showDialog(playingFieldToString)
  }



  def evaluateMoveToString: String = {
    var myString: String = "Uncovered Cards of each Player "
    controller.getPlayers.foreach((player: IPlayer) => myString = myString + player.namePlayer+":" + player.cards.cards(controller.getI) + " ")
    myString = myString + " -> current points for each player: "
    controller.getPlayers.foreach((player: IPlayer) => myString = myString  + player.namePlayer+":" + player.pointsForOneRound + " ")

    myString
  }

  def playingFieldToString: String = {
    var myOutput = ""
    controller.getPlayers.foreach((player: IPlayer) => myOutput = myOutput + "PlayerName: " + player.namePlayer + " has Cards: " + player.cards
      + "pointsForOneRound: " + player.pointsForOneRound + ",totalPoints: " + player.totalPoints + "\n")
    myOutput
  }


}

