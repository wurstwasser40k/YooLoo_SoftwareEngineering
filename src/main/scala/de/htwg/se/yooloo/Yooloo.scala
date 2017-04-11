package de.htwg.se.yooloo

import de.htwg.se.yooloo.model.{CardSet, Player}

/**
 * Created by Vk on 07.04.2017.
 */
object Yooloo {
  def main(args: Array[String]): Unit = {
    println("Yooloo startet nun.")

    println("Der Spieler heißt: " )
    val namePlayer = scala.io.StdIn.readLine()

    val set1 = new CardSet()
    set1.sortCardSet

    println(set1.cardSet)

    val player = new Player(namePlayer, set1)
    println()
    println(player.toString)

  }

}
