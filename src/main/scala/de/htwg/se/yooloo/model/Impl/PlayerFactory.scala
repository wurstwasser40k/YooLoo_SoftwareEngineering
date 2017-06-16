package de.htwg.se.yooloo.model.Impl

import de.htwg.se.yooloo.model.{ICards, IPlayer, IPlayerFactory}

class PlayerFactory extends IPlayerFactory {

  def create(namePlayer: String, cards: ICards, pointsForOneRound: Int, totalPoints: Int): IPlayer = {
    new Player(namePlayer, cards, pointsForOneRound, totalPoints)
  }

  def create(namePlayer: String): IPlayer = {
    new Player(namePlayer)
  }

  def create(namePlayer: String, tp: Int): IPlayer = {
    new Player(namePlayer, tp)
  }

  def create(namePlayer: String, cards: ICards, tp: Int): IPlayer = {
    new Player(namePlayer, cards, tp)
  }
}