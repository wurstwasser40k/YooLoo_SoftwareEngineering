package de.htwg.se.yooloo.model

import scala.util.Random

/**
 * Created by svenb on 29.03.2017.
 */

//TODO: Alles println ist muss in die view/TUI
case class CardSet() {

  //TODO:cardSet als Klassen-Parameter setzen (in Konstruktor)...wenn etwas geändert wird, dann neu erzeugen
  var cardSet: List[Int] = Nil
  //the cards in the set

  def addToCardset(input: Int) {


    //if wrong userinput
    if (input <= 0 || input >= 11 || cardSet.contains(input) == true) {
      println("Wrong User-Input: Card has to be between 1-10, or the card you wanted to add is already " +
        " is already inside your cardset -> Choose another card!")

    } else {
      cardSet = input :: cardSet
      println("Your current cardSet: " + cardSet)
      if (cardSet.length <= 8) {
        println("Which card do you want to put next?")
      }
    }
  }

  def sortCardSet: Unit = {
    println("Which card do you want to put first?")

    while (cardSet.length <= 9) {
      try {
        val input = scala.io.StdIn.readInt()
        addToCardset(input)
      } catch {
        case e: NumberFormatException => println("You have to type an Int-value...String is not allowed")
        case oe: Exception => println("Other Exception")
      }
    }
  }

  /**
   * This method sorts the cardDeck automatically (by random)
   */
  def sortCardSetAutomatically: Unit = {

    val myRandStream = new Random()

    while (cardSet.length <= 9) {
      try {
        val input = myRandStream.nextInt(10) + 1
        addToCardset(input)
      } catch {
        case e: NumberFormatException => println("You have to  type an Int-value...String is not allowed")
        case oe: Exception => println("Other Exception")
      }
    }


    println(this.toString + "has been sorted automatically")
  }
}