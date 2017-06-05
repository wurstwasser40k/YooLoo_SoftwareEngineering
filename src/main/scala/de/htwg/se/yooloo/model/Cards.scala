package de.htwg.se.yooloo.model

case class Cards(cards: List[Int]) {

  def addCard(input: Int): Cards = {
    if (checkCard(input)) {
      val tmpList: List[Int] = input :: cards
      val tmpCards = new Cards(tmpList)
      return tmpCards
    }
    this
  }

   private def checkCard(input: Int): Boolean = {
    if ((input <1 && input >= 10) || cards.contains(input)) {
      false
    }
    else {
      true
    }
  }
  //def checkIsCompleted: höchster Integer in List == cards.length-1
  override def toString: String = {
    var myString = ""
    if (cards != null) cards.foreach(card => myString += card + " | ")
    myString
  }
}