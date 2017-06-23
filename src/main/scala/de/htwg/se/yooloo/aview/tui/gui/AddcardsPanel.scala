package de.htwg.se.yooloo.aview.tui.gui

import de.htwg.se.yooloo.controller.Impl.{CardAddedEvent, Controller, CurrentPlayerEvent}

import scala.swing.{Dimension, GridPanel, TextField}

/**
  * Created by svenb on 16.06.2017.
  * On this surface the cards will be uncovered
  */
class AddcardsPanel(controller: Controller) extends GridPanel(2, 1)  {
  preferredSize = new Dimension(500, 200)

  listenTo(controller)


  val playerNameField = new TextField(){
    text= ""
  }
 val displayField = new TextField(){
   text= ""
 }


  contents += playerNameField
  contents += displayField



  reactions += {
    case e:CardAddedEvent => displayCardStatus()
    case e:CurrentPlayerEvent => displayCurrentPlayer()
  }


  def displayCardStatus() = {
    val myCardStatus:String = "Player " + controller.getNameCurrentPlayer + " has the following cards: " + controller.getPlayers()(controller.getIndexCurrentPlayer).cards.toString
    displayField.text=myCardStatus
  }

  def displayCurrentPlayer(): Unit ={
    playerNameField.text=  "Current player is: " + controller.getNameCurrentPlayer
    displayField.text=""
  }

}
