package de.htwg.se.yooloo.model

case class Cards(cards: List[Int]) {

  override def toString: String = {
    var myString = ""
    cards.foreach(card => myString = myString + card + " ")
    myString
  }

}