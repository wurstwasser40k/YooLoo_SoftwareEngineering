package de.htwg.se.yooloo

import de.htwg.se.yooloo.model.{CardSet, Player}

/**
 * Created by Vk on 07.04.2017.
 */

//TODO:Muss NUR die TUI/GUI starten!!
//initialisiert das Modell und den Controller
object Yooloo {
  def main(args: Array[String]): Unit = {
    println("Yooloo is starting...")

    println("Type the name of player 1?: ")
    val namePlayer1 = scala.io.StdIn.readLine()
    val player1 = new Player(namePlayer1)
    val set1 = new CardSet()

    println("AI-Player...Type the name of player 2?: ")
    val namePlayer2 = scala.io.StdIn.readLine()
    val player2 = Player(namePlayer2)
    val set2 = CardSet()

    println("AI-Player...Type the name of player 3?: ")
    val namePlayer3 = scala.io.StdIn.readLine()
    val player3 = Player(namePlayer3)
    val set3 = CardSet()
    /*
        //Set up playing field
        val playingField = new PlayingField(player1, player2, player3)
        playingField.makeAMove()

        println(player1.namePlayer + " has points (in total):" + player1.totalPoints)
        println(player2.namePlayer + " has points (in total):" + player2.totalPoints)
        println(player3.namePlayer + " has points (in total):" + player3.totalPoints)
        */

  }
}