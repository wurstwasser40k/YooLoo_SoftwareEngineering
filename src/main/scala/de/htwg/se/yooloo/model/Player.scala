package de.htwg.se.yooloo.model

/**
  * Created by svenb on 29.03.2017.
  */
class Player(val namePlayer:String, val cardSet: CardSet) {

 var points:Int = 0 //TODO: Ist var okay, not immutable?
 var totalPoints:Int =0 //TODO: Ist var okay, not immutable?


  def addPoints(points:Int): Unit ={
    this.points=this.points  + points
  }

}
