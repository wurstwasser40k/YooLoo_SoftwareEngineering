package de.htwg.se.yooloo

import de.htwg.se.yooloo.aview.tui.Tui
import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.model.Player
import de.htwg.se.yooloo.util.GameStartedEvent

object Yooloo {

  val controller = new Controller(List(new Player(null)))
  val tui = new Tui(controller)

  controller.notifyObservers(GameStartedEvent)

  def main(args: Array[String]): Unit = {

    var input: String = ""
    var continue: Boolean = true

    do {
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)
    } while (continue)
  }
}