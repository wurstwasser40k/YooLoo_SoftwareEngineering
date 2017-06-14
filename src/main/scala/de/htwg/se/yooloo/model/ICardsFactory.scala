package de.htwg.se.yooloo.model

trait ICardsFactory {

  def create(cards: List[Int]): ICards

}
