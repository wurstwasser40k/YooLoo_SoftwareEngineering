package de.htwg.se.yooloo


import de.htwg.se.yooloo.aview.tui.Tui
import de.htwg.se.yooloo.aview.tui.gui.Gui
import de.htwg.se.yooloo.controller.Impl.{Controller, GameStartedEvent}
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}

object Yooloo {

  val amountOfCards=5
  val amountOfMaxPlayers=4
  //DI: Instanz für INterface IPlayerFActory statt new PlayerFactory
  val controller = new Controller(List((new PlayerFactory).create(null)), new PlayerFactory, new CardsFactory, amountOfCards, amountOfMaxPlayers)
  val tui = new Tui(controller)
  val gui =  new Gui(controller)
  controller.publish(new GameStartedEvent())      //controller.notifyObserver(GameStartedEvent)

  def main(args: Array[String]): Unit = {

    var input: String = ""
    var continue: Boolean = true

    do {
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)
    } while (continue)
  }
}