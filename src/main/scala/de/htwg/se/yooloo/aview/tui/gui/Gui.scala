package de.htwg.se.yooloo.aview.tui.gui


import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing._

/**
  * Created by svenb on 16.06.2017.
  */
class Gui(controller: Controller) extends Frame {

  listenTo(controller)

  title = "HTWG YooLoo"

  contents = new BorderPanel {
    add(new SortPanel(controller), BorderPanel.Position.West)
    add(new UncoverPanel(controller), BorderPanel.Position.Center)
    add(new PointsPanel(controller), BorderPanel.Position.East)   //ggf. weglassen
  }

  menuBar = new MenuBar {
  contents += new Menu("Options") {
    contents += new MenuItem(Action("Redo last move") { controller.redo })
    contents += new MenuItem(Action("Undo last move") { controller.undo })
    contents += new MenuItem(Action("Exit") { System.exit(-1) })
  }
  }





  resizable = false
  visible = true
}