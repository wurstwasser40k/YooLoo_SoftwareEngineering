package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.model.{Player, PlayingField}

/**
  * Created by Vk on 16.04.2017.
  */

//TODO: Zwei Spieler mit einer Karte muss machbar sein, für Testzwecke (Nach unten Skalierbarkeit)
//TODO: Strings sammeln, und gebündelt als println ausgeben
//Muss Klasse sein, extends App muss raus
object Tui extends App {

  /**
    * TODO:
    * -   Klasse fertig bauen
    * -   dann Klassendeklaration ändern in  class
    *
    */

  var playingField = initPlayers()

  playingField.makeAMove()


  def initPlayers() = {
    println("Player 1 -")

    var player1 = new Player(enterPlayerName())
    println("Player 2 -")

    var player2 = new Player(enterPlayerName())
    println("Player 3 - ")

    var player3 = new Player(enterPlayerName())

    val listPlayer = List(player1, player2, player3)

    PlayingField(listPlayer)
  }


  def enterPlayerName() = {
    println("Enter your name: ")
    scala.io.StdIn.readLine()
  }
}