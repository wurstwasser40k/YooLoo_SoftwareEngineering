package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.util.Observer

/**
  * Created by Vk on 16.04.2017.
  */

//TODO: Strings sammeln, und gebündelt als println ausgeben
/**
  * ***** Info ****
  * Tui is the concrete subject and has to implement Controller.update()
  * Observable.update() obtains state information from the subject and acts on that state
  * ****  Info ****
  */
class Tui(controller: Controller)  extends Observer {

  controller.add(this)


  def enterplayerNames(input: String){
    input match {
      case "f" => println("Finished entering Player Names..you´re ready to play") //Test what happens if no players are added
      case _ => controller.initPlayer(input)

    }
  }

  def enterCard(input: String): Unit ={
      input match {
        case "1" | "2"| "3" | "4" | "5" | "6" | "7" | "8"| "9"  | "10" => controller.addCard(input)
        case _ => println("wrong input - please type a number between 1 and 10")
      }
  }

  def pressEnter():Unit ={

     controller.evaluatePoints

  }


  override def update: Unit =  println(controller.playingFieldToString)
}