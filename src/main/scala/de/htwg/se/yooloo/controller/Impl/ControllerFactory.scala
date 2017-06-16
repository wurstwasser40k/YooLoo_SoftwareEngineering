package de.htwg.se.yooloo.controller.Impl

import de.htwg.se.yooloo.model.{ICardsFactory, IPlayer, IPlayerFactory}
import de.htwg.se.yooloo.util.Observable

trait ControllerFactory extends Observable {

  def create(players: List[IPlayer], playerFactory: IPlayerFactory, cardsFactory: ICardsFactory): IController

}