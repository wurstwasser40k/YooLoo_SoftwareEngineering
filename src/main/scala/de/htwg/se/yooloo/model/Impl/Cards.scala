package de.htwg.se.yooloo.model.Impl

import de.htwg.se.yooloo.model.ICards

case class Cards(override val cards: List[Int]) extends ICards {

  def addCard(input: Int): Cards = {
    if (checkCard(input)) {
      val tmpList: List[Int] = input :: cards
      val tmpCards = new Cards(tmpList)
      return tmpCards
    }
    this
  }

  private def checkCard(input: Int): Boolean = {
    if ((input < 1 || input >= 10) || cards.contains(input)) {
      false
    }
    else {
      true
    }
  }

  override def toString: String = {
    var myString = ""
    if (cards != null) cards.foreach(card => myString += card + " | ")
    myString
  }
}