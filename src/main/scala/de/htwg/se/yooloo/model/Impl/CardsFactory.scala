package de.htwg.se.yooloo.model.Impl

import de.htwg.se.yooloo.model.{ICardsFactory, ICards}

class CardsFactory extends ICardsFactory{

  def create(cards: List[Int]): ICards = {
    new Cards(cards)
  }
}
