package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */

//TODO: Alles println ist muss in die view/TUI
case class CardSet(numCardsParam:Int) {

  val numCards=this.numCardsParam

  //TODO:cardSet als Klassen-Parameter setzen (in Konstruktor)...wenn etwas geändert wird, dann neu erzeugen
  var cardSet: List[Int] = Nil  //the cards in the set


   override def toString:String={
     var myString =""
     cardSet.foreach(card => myString=myString+card+" ")
     myString
   }

}