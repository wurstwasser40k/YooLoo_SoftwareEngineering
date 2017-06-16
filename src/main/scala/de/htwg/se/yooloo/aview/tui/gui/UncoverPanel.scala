package de.htwg.se.yooloo.aview.tui.gui

import java.awt.Dimension

import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing.{GridPanel, TextField}

/**
  * Created by svenb on 16.06.2017.
  * On this surface the cards will be uncovered
  */
class UncoverPanel(controller: Controller) extends GridPanel(controller.getAmountOfPlayers(), 1)  {
  preferredSize = new Dimension(100, 100)
  val gridHeight = controller.getAmountOfPlayers()
  val gridWidth = 1
  listenTo(controller)

  //Draw Cells
  for (viewRow <- (0 until gridHeight) reverse)
    contents += new TextField(){
      text=""+0  //TODO: Hier muss ich an die Punkte meiner Spieler kommen
      //   text=""+controller.getPlayers().apply(viewRow).pointsForOneRound


    }
}
