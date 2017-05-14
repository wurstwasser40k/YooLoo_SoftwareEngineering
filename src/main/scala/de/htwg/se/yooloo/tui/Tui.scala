package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.util.{MoveEvaluatedEvent, _}

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

    try{
      var myInput:Int = input.toInt
      controller.addCard(myInput)
    }catch{
      case e: NumberFormatException => println("Please enter a number")
    }

  }

  def pressEnter(i:Int):Unit ={

     controller.evaluatePoints(i:Int)

  }


  def continueOrQuit(input:String): Unit ={
    input match {
      case "y" => println("Next round starts now")
                  controller.newRoundStarted()
      case _ => println("Thanks for playing")


    }
  }

  override def update(e:Event): Unit = {

 //   println(controller.playingFieldToString)

    e match{
      case GameStartedEvent => println("Welcome to YooLoo - please enter PlayerNames and then hit f and enter")
       case CreatedPlayerEvent =>   println(controller.playerCreationToString)
       case CardAddedEvent =>   println(controller.cardAddedToString)
       case MoveEvaluatedEvent =>   println(controller.evaluateMoveToString )
       case RoundEvaluated =>   println(controller.playingFieldToString)


       case _ => println(controller.playingFieldToString)
    }

  }
}