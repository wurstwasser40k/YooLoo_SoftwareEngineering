package de.htwg.se.yooloo.model

case class Cards(cards: List[Int]) {

  def addCard(input: Int): Cards = {
    if (cards(0) == null) copy(cards = List(input))
    if (checkCard(input)) {this.copy(cards = input :: this.cards)}
    this
  }

  def checkCard(input: Int): Boolean = {
    if (input <= 0 || cards.contains(input)) {
      false
    }
    else {
      true
    }
  }

  //def checkIsCompleted: höchster Integer in List == cards.length-1

  override def toString: String = {
    var myString = ""
    if (cards != null) cards.foreach(card => myString = myString + card + " ")
    myString
  }
}