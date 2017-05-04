package de.htwg.se.yooloo

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.tui.Tui

/**
 * Created by Vk on 07.04.2017.
 */

//TODO:Muss NUR die TUI/GUI starten!!
//initialisiert das Modell und den Controller
object Yooloo {



  //Model-class
  val playingField = new PlayingField(List(new Player("A"),new Player("B"),new Player("C")))  //TODO: mit Methode initPlayer() lösen
  //conmtroller-class
  val controller =  new Controller(playingField)
  //view-class
  val  tui = new Tui(controller)


  controller.notifyObservers


  def main(args: Array[String]): Unit = {

    var input:String=""

//Enter Playernames -> Players are created until the user hits f for finish
    do{
      input=scala.io.StdIn.readLine()

      tui.enterplayerNames(input)

    }while(input!="f")





   //TODO: Wie kommt man von hier zu addCards????
    do{
      input=scala.io.StdIn.readLine()

      tui.enterCard(input)

    }while(input!="q")

  }
}