package de.htwg.se.yooloo.aview.tui

/**
  * Created by svenb on 16.06.2017.
  */

import swing._

object Test extends SimpleSwingApplication{
  override def top: Frame = new MainFrame{
    title="HelloWorld"
    contents=new Button("Click me")
  }
}
