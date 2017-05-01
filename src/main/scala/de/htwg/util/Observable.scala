package de.htwg.util

/**
  * Created by Vk on 30.04.2017.
  */
trait IObserver {
 def update()
}

class Observable {
  //List of Observer-Elements
  var subscribers: Vector[IObserver] = Vector()


  def add(s:IObserver): Unit = subscribers= subscribers :+ s

  def remove(s:IObserver): Unit = subscribers = subscribers.filterNot(o => o == s)

  def notifyObservers: Unit = subscribers.foreach(o => o.update())
}