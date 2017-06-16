package de.htwg.se.yooloo.aview.tui.gui


import de.htwg.se.yooloo.controller.Impl.Controller

import scala.swing.{Label, _}

/**
  * Created by svenb on 16.06.2017.
  */
class SwingGui(controller: Controller) extends Frame {


  title = "HTWG YooLoo"


  contents = new FlowPanel {
    contents += new Label("Das ist ein Label")
    contents += new Button{
      text="click me"
    }
  }




 // resizable = false
  visible = true
}