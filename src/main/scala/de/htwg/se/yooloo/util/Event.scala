package de.htwg.se.yooloo.util

/**
  * Either we do it like this, or we define 4 individual objects
  */
class Event( ) {


/*
  type CreatedPlayerEvent
  type CardAddedEvent
  type MoveEvaluatedEvent //show card each Player, and whether there is a winner...and amount of points
  type RoundEvaluated

*/
}


object GameStartedEvent extends Event{

}

object CreatedPlayerEvent extends Event{

}


object CardAddedEvent extends Event{

}


object MoveEvaluatedEvent extends Event{

}

object RoundEvaluated extends Event{

}
