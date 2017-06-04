package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.model.Player
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

  val statusLine = "Welcome to HTWG Yooloo!"
  var nameCurrentPlayer: String = _
  var pointsInThePot: Int = 0
  var finishedRound = false
  var pointValue = 1
  var i = 0

  /*
  def playingFieldToString: String = playingField.toString()
  def cardAddedToString: String = playingField.cardAddedToString
  def evaluateMoveToString: String = playingField.evaluateMoveToString
  */

  def addPlayer(input: String): Unit = {
    val player = new Player(input)
    players.head.namePlayer match {
      case a if a == null => players = List(player)
      case _ => players = player :: players
    }
    notifyObservers(CreatedPlayerEvent)
  }

  def setNameCurrentPlayer(): Unit = {
    val indexCurrentPlayer = players.indexWhere(_.namePlayer == nameCurrentPlayer)
    indexCurrentPlayer match {
      case 0 =>
      case -1 => this.nameCurrentPlayer = players.head.namePlayer
      case _ if indexCurrentPlayer < players.length - 1 => nameCurrentPlayer = players(indexCurrentPlayer).namePlayer
    }
  }
/*
  def addCard(input: Int): Unit = {
    var tempPlayers = players
    val iCurrentPlayer = players.indexWhere(_.namePlayer == nameCurrentPlayer)
    val addedCards = players(iCurrentPlayer).cards.addCard(input)
    val updatedPlayer = new Player(nameCurrentPlayer, addedCards)
    //replace within list!
    tempPlayers.updated(iCurrentPlayer, updatedPlayer)
    notifyObservers(CardAddedEvent)
  }


  //decides who gets points
  def decideWhoGetsThePoint(pointValue: Int, i: Int): Unit = {

    var currentListCards: List[Int] = Nil

    players.foreach((player: Player) => currentListCards = player.cards.cards(i) :: currentListCards)
    var dupCards: List[Int] = Nil
    dupCards = currentListCards

    //new List contains only the duplicate(s)
    dupCards = dupCards.diff(dupCards.distinct).distinct

    //filter duplicated values from currentListCards
    currentListCards = currentListCards.filterNot(dupCards.toSet)

    /*case1: winner:
    - call addPoints
    - reset pot points
     */
    if (currentListCards != Nil) {
      //find largest Int-Value

      var largesVal: Int = currentListCards.max
      var winner: Player = players.head

      players.foreach((player: Player) => if (player.cards.cards(i) == largesVal) winner = player)
      winner.addPoints(pointValue)
      pointsInThePot = 0
    }

    /*case2: No winner
    add points to pot
     */
  }

  def newRoundStarted(): Unit = {
    players.foreach((player: Player) => player.copy(cards = Cards(List(0))).copy(pointsForOneRound = 0))
    currentPlayer_=(players(players.length - 1))
    this.pointValue = 1
    this.finishedRound = false
  }


  def evaluatePoints(i: Int): Unit = {
    this.i = i
    this.pointsInThePot += this.pointValue
    this.decideWhoGetsThePoint(this.pointsInThePot, i)

    this.pointValue += 1

    notifyObservers(MoveEvaluatedEvent)

    if (i + 1 == players.head.cards.cards.length) {
      this.finishedRound = true
      notifyObservers(RoundEvaluated)
    }
  }

  def checkIfRoundFinished: Boolean = {
    if (this.finishedRound) {
      true
    }
    else {
      false
    }
  }

  //ist aktuelles cardSet genauso lange wie vorheriges?
  def checkFullCardSet(): Boolean = {
    if (players.head.cards.cards.length == currentPlayer.cards.cards.length) {
      true
    }
    else {
      false
    }
  }
  */
}