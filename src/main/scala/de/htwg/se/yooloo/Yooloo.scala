package de.htwg.se.yooloo

import de.htwg.se.yooloo.model.CardSet

/**
 * Created by Vk on 07.04.2017.
 */
object Yooloo {
  def main(args: Array[String]): Unit = {
    println("Yooloo startet nun.")

    val set1 = new CardSet()
    set1.sortCardSet

    println(set1.cardSet)

  }

}
