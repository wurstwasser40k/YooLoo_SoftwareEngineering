package de.htwg.se.yooloo

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.tui.Tui

//initialisiert das Modell und den Controller
object Yooloo {

  val controller = new Controller()
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    tui.initPlayers()
    //TODO: do - while Schleife mit processInputLine()
  }
}