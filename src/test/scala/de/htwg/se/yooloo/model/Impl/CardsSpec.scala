package de.htwg.se.yooloo.model.Impl

import org.scalatest.{Matchers, WordSpec}

class CardsSpec extends WordSpec with Matchers {

  "A list of cards" when {
    "empty" should {
      val cards: Cards = null
      "throw a java.lang.NullPointerException" in {
        assertThrows[java.lang.NullPointerException] {
          cards.toString
        }
      }
    }
    "not empty" should {
      val cardsFilled: Cards = Cards(List(4, 1))
      "not be empty" in {
        assert(cardsFilled.cards.nonEmpty)
      }
      "have size > 0" in {
        assert(cardsFilled.cards.size > 0)
      }
      "write current cards toString" in {
        cardsFilled.toString should be("4 | 1 | ")
      }
    }
    "one card is added" should {
      val cards: Cards = Cards(List(2, 1))
      "add card to list if allowed and return new list of cards" in {
        cards.addCard(3) should be(Cards(List(3, 2, 1)))
      }
      "not add card to list if not allowed" in {
        cards.addCard(2) should be(Cards(List(2, 1)))
        cards.addCard(0) should be(Cards(List(2, 1)))
        cards.addCard(12) should be(Cards(List(2, 1)))
      }
    }
  }
}