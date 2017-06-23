package de.htwg.se.yooloo.aview.gui


import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing._

class Gui(controller: Controller) extends Frame {

  listenTo(controller)

  title = "HTWG YooLoo"

  contents = new BorderPanel {
    add(new SortPanel(controller), BorderPanel.Position.West)
    //TODO: UncoverPanel und PointsPanel wegwerfen, dafür InfoPanel reinbauen, um die nervigen Popups zu sparen?
     add(new UncoverPanel(controller), BorderPanel.Position.Center)  //ggf. weglassen
     add(new PointsPanel(controller), BorderPanel.Position.East)     //ggf. weglassen
    add(new MenuePanel(controller), BorderPanel.Position.South)
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
  repaint()
}