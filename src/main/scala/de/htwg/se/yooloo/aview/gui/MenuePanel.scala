package de.htwg.se.yooloo.aview.gui

import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing.{Action, Button, GridPanel}

/**
  * This surface shows the points for one round
  */
class MenuePanel(controller: Controller) extends GridPanel(1, 3)  {

//  preferredSize = new Dimension(100, 100)
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
