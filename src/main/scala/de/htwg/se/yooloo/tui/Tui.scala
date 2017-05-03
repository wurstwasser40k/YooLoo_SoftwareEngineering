package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.controller.Controller
import de.htwg.util.IObserver

//TODO: Strings sammeln, und gebündelt als println ausgeben
  /**
  * ***** Info ****
  * Tui is the concrete subject and has to implement Controller.update()
  * Observable.update() obtains state information from the subject and acts on that state
  * ****  Info ****
  */

class Tui(controller: Controller) extends IObserver {





  //playingField.makeAMove()

  //TODO: Aktivitäten sammeln in processInputLine(input:String)

 //Hier steht später die playingFieldToString via controller
  override def update(): Unit = "Hier steht künftig der neue Zwischenstand des Spieles."

}