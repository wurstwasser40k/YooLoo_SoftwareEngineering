package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.model.{ Player, PlayingField }

/**
 * Created by Vk on 16.04.2017.
 */
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

    PlayingField(player1, player2, player3)
  }

  def enterPlayerName() = {
    println("Enter your name: ")
    scala.io.StdIn.readLine()
  }


}