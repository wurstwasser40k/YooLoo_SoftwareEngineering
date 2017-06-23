package de.htwg.se.yooloo.aview.gui

import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing.{Action, Button, GridPanel}

/**
  * Created by svenb on 16.06.2017.
  * This surface shows the points for one round
  */
class MenuePanel(controller: Controller) extends GridPanel(1, 3)  {


  listenTo(controller)


    contents += new Button(){
      action = Action("Next Player"){
        controller.changeCurrentPlayer()
      }
    }
      contents += new Button(){
    action = Action("Evaluate"){
      controller.evaluatePoints()
    }
  }
  contents += new Button(){
    action = Action("Play Again"){
      controller.newRoundStarted()
    }
  }


}
