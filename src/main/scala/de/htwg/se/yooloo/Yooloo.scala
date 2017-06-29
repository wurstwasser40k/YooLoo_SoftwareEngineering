package de.htwg.se.yooloo


import com.google.inject.Guice
import de.htwg.se.yooloo.aview.gui.Gui
import de.htwg.se.yooloo.aview.tui.Tui
import de.htwg.se.yooloo.controller.GameStartedEvent
import de.htwg.se.yooloo.controller.Impl.Controller
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}

object Yooloo {

  val amountOfCards = 5
  val amountOfMaxPlayers = 4
  val injector = Guice.createInjector(new YoolooModule)
  val playerFactory = injector.getInstance(classOf[PlayerFactory])
  val cardsFactory = injector.getInstance(classOf[CardsFactory])


  val controller = new Controller(List((playerFactory).create(null)), playerFactory, cardsFactory, amountOfCards, amountOfMaxPlayers)
  val tui = new Tui(controller)
  val gui = new Gui(controller)
  controller.publish(new GameStartedEvent()) //controller.notifyObserver(GameStartedEvent)

  def main(args: Array[String]): Unit = {

    var input: String = ""
    var continue: Boolean = true

    do {
      input = scala.io.StdIn.readLine()
      tui.processInputLine(input)
    } while (continue)
  }
}