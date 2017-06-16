package de.htwg.se.yooloo

import de.htwg.se.yooloo.aview.tui.Tui
import de.htwg.se.yooloo.controller.Impl.IController
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}
import de.htwg.se.yooloo.util.GameStartedEvent

object Yooloo {

  //DI: Instanz für Interface IPlayerFactory statt new PlayerFactory

  val controller = {
    new IController(List((new PlayerFactory).create(null)), new PlayerFactory, new CardsFactory)
  }

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