package de.htwg.se.yooloo.model

trait ICardsFactory {

  def create(cards: List[Int]): ICards

}

trait IPlayerFactory {

  def create(namePlayer: String, cards: ICards, pointsForOneRound: Int, totalPoints: Int): IPlayer

  def create(namePlayer: String): IPlayer

  def create(namePlayer: String, tp: Int): IPlayer

  def create(namePlayer: String, cards: ICards, tp: Int): IPlayer

}