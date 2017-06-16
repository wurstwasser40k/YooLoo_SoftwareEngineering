package de.htwg.se.yooloo.controller.Impl

/**
  * Created by svenb on 16.06.2017.
  */

import scala.swing.event.Event

class GameStartedEvent extends Event {}

class CreatedPlayerEvent extends Event {}

class CurrentPlayerEvent extends Event {}

class FullCardsEvent extends Event {}

class CardAddedEvent extends Event {}

class MoveEvaluatedEvent extends Event {}

class RoundEvaluated extends Event {}

