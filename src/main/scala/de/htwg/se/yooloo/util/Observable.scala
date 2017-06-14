package de.htwg.se.yooloo.util

/**
  * oAdds an observer to the internal list of observers.
  * protected void setChanged()
  * oSets the internal flag that indicates this observable has changed state
  * public void notifyObservers()
  * oChecks the internal flag to see if the observable has changed state and notifies all observers
  */

trait Observer {
  def update(e: Event): Unit
}

class Observable {
  var subscribers: Vector[Observer] = Vector()

  //Adds an observer to the internal list of observers.
  def add(s: Observer): Unit = subscribers = subscribers :+ s

  def remove(s: Observer): Unit = subscribers = subscribers.filterNot(o => o == s)

  //checks the internal flag to see if the observable has changed state and notifies all observers
  def notifyObservers(event: Event): Unit = subscribers.foreach(o => o.update(event))
}