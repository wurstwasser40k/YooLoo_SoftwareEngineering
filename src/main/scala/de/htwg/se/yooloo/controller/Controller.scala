package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.{Cards, Player}
import de.htwg.se.yooloo.util._

class Controller(var players: List[Player]) extends Observable {

  /*
  1. Name des Spielers einfügen                               -> any String, mehr als zwei Zeichen
  2. Fertig mit Spieler einfügen                              -> f
  3. cards des jeweiligen Spielers füllen                     -> Int zwischen 1 - 9
  4. nächster Spieler füllt seine cards                       -> c
  5. Punkte evaluieren (aktueller Stand, Gesamter Stand)      -> e
  6. Neues Spiel                                              -> n
  7. quit                                                     -> q
   */

  var indexCurrentPlayer: Int = 0
  var currentNamePlayer: String = players(indexCurrentPlayer).namePlayer
  var pointsInThePot: Int = 0
  // var finishedRound = false
  var pointValue = 1
  var i = 0

  def addPlayer(input: String): Unit = {
    val player = new Player(input)
    players.head.namePlayer match {
      case a if a == null => players = List(player)
      case _ => players = player :: players
    }
    notifyObservers(CreatedPlayerEvent)
  }


  def setCurrentPlayer(): Unit = {
    indexCurrentPlayer match {
      case b if b < players.size - 1 => this.currentNamePlayer = players(indexCurrentPlayer).namePlayer
        notifyObservers(CurrentPlayerEvent)
    }
  }

  def changeCurrentPlayer(): Unit = {
    indexCurrentPlayer match {
      case b if b < players.size - 1 => this.currentNamePlayer = players(indexCurrentPlayer + 1).namePlayer
        this.indexCurrentPlayer += 1
        notifyObservers(CurrentPlayerEvent)
    }
  }

  def insertCards(input: Int): Unit = {
    if (players(1).cards == null) {
      addCard(input)
    }
    else if (
    //TODO: wenn cards currentPlayer länger als cards des ersten
      this.players(indexCurrentPlayer - 1).cards.cards.length
        == players(0).cards.cards.length) {
      addCard(input)
    }
    else notifyObservers(FullCardsEvent)
  }


  def addCard(input: Int): Unit = {
    //  tmpCards
    var tmpCards = players(indexCurrentPlayer).cards
    var tmpPlayer: Player = null
    tmpCards match {
      case a if a == null =>
        tmpCards = Cards(List(input))
        tmpPlayer = new Player(currentNamePlayer, tmpCards, players(indexCurrentPlayer).totalPoints)

      case _ => tmpCards = tmpCards.addCard(input)
        tmpPlayer = new Player(currentNamePlayer, tmpCards,  players(indexCurrentPlayer).totalPoints)
    }

    var tmpPlayers: List[Player] = players
    tmpPlayers = tmpPlayers.updated(indexCurrentPlayer, tmpPlayer)

    players = tmpPlayers
    //currPlayer = players(indexCurrentPlayer)
    notifyObservers(CardAddedEvent)
  }

  def evaluatePoints(): Unit = {
    this.pointsInThePot += this.pointValue
    this.decideWhoGetsThePoint(this.pointsInThePot, i)
    this.pointValue += 1
    notifyObservers(MoveEvaluatedEvent)
    if (i + 1 == players.head.cards.cards.length) {

      notifyObservers(RoundEvaluated)
    }
    this.i += 1
  }

  def decideWhoGetsThePoint(pointValue: Int, i: Int): Unit = {

    var tmpListCards: List[Int] = Nil

    players.foreach((player: Player) => tmpListCards = player.cards.cards(i) :: tmpListCards)
    var dupCards: List[Int] = Nil
    dupCards = tmpListCards

    //new List contains only the duplicate(s)
    dupCards = dupCards.diff(dupCards.distinct).distinct

    //filter duplicated values from tmpListCards
    tmpListCards = tmpListCards.filterNot(dupCards.toSet)

    if (tmpListCards != Nil) {

      val largesVal: Int = tmpListCards.max
      var winner: Player = players.head

      players.foreach((player: Player) => if (player.cards.cards(i) == largesVal) winner = player)
      val tmpPoints = winner.pointsForOneRound
      winner = winner.addPoints(tmpPoints + pointValue, winner.totalPoints + pointValue)
      var tmpPlayers = players
      players.foreach((player: Player) => if (player.namePlayer == winner.namePlayer) {
        tmpPlayers = tmpPlayers.updated(players.indexOf(player), winner)
      })
      players = tmpPlayers
      pointsInThePot = 0
    }
  }


  def newRoundStarted(): Unit = {
    var tmpPlayers: List[Player] = List(new Player(players(0).namePlayer, players(0).totalPoints))

    players.foreach((player: Player) => if (player.namePlayer != players(0).namePlayer) {
      tmpPlayers = new Player(player.namePlayer, player.totalPoints) :: tmpPlayers
    })
    players = tmpPlayers
    this.indexCurrentPlayer = 0
    this.pointValue = 1
    this.i = 0
    notifyObservers(CurrentPlayerEvent)
  }

  def exit(): Unit ={
    System.exit(0)
  }
}