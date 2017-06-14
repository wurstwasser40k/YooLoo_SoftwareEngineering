package de.htwg.se.yooloo.model

import de.htwg.se.yooloo.model.Impl.Cards

trait IPlayerFactory {

  def create(namePlayer: String, cards: Cards, pointsForOneRound: Int, totalPoints: Int): IPlayer

  def create(namePlayer: String): IPlayer

  def create(namePlayer: String, tp: Int): IPlayer

  def create(namePlayer: String, cards: Cards, tp: Int): IPlayer

}
