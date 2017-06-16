package de.htwg.se.yooloo.aview.tui.gui

import de.htwg.se.yooloo.controller.Impl.{Controller, CurrentPlayerEvent}

import scala.swing.{Action, Button, GridPanel}

/**
  * Created by svenb on 16.06.2017.
  *  On this surface the cards will be sorted
  */
class SortPanel(controller: Controller) extends GridPanel(1, controller.getAmountOfCards()){

  val gridHeight = 1 //alternativ setzt man es auf die Anzahl der Spieler controller.getAmountOfPlayers()
  val gridWidth = controller.getAmountOfCards()
  listenTo(controller)


  for (viewRow <- (0 until gridHeight) reverse; viewCol <- (0 until gridWidth)){
    contents += new Button(""+(viewCol+1)){
      action = Action(""+(viewCol+1)){
        controller.addCard(viewCol+1)
        visible=false
      }
    }
  }


  reactions += {
    case e: CurrentPlayerEvent => repaint()

  }


}

