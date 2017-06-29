package de.htwg.se.yooloo

import com.google.inject.AbstractModule
import de.htwg.se.yooloo.model.{ICardsFactory, IPlayerFactory}
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}


class YoolooModule extends AbstractModule {
  override def configure = {
    bind(classOf[IPlayerFactory]).to(classOf[PlayerFactory])
    bind(classOf[ICardsFactory]).to(classOf[CardsFactory])
  }
}
