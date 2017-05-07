package de.htwg.se.yooloo

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.model.PlayingField
import de.htwg.se.yooloo.tui.Tui

/**
 * Created by Vk on 07.04.2017.
 */


//initialisiert das Modell und den Controller
object Yooloo {

  //Model-class
  val playingField = new PlayingField(4)
  //conmtroller-class
  val controller =  new Controller(playingField)
  //view-class
  val  tui = new Tui(controller)


  controller.notifyObservers


  def main(args: Array[String]): Unit = {

    var input:String=""
    var i:Int=0



    do{
      input=scala.io.StdIn.readLine()
      tui.enterplayerNames(input)
    }while(input!="f")

    do{
      input=scala.io.StdIn.readLine()
      tui.enterCard(input)
    }while(!controller.checkFullCardSet())

    do{
      input=scala.io.StdIn.readLine()
      tui.pressEnter(i)
      i=i+1
    }while(!controller.checkIfRoundFinished) //TODO: Abbruchbedinging



  }
}