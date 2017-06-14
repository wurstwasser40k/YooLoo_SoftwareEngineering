package de.htwg.se.yooloo.model.Impl

import de.htwg.se.yooloo.model.{IPlayer, IPlayerFactory}

class PlayerFactory extends IPlayerFactory {

  def create(namePlayer: String, cards: Cards, pointsForOneRound: Int, totalPoints: Int): IPlayer = {
    new Player(namePlayer, cards, pointsForOneRound, totalPoints)
  }

  def create(namePlayer: String): IPlayer = {
    new Player(namePlayer)
  }

  def create(namePlayer: String, tp: Int): IPlayer = {
    new Player(namePlayer, tp)
  }

  def create(namePlayer: String, cards: Cards, tp: Int): IPlayer = {
    new Player(namePlayer, cards, tp)
  }
}