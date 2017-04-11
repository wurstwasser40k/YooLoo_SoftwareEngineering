package de.htwg.se.yooloo.model

/**
  * Created by svenb on 29.03.2017.
  */

case class CardSet() {

  var cardSet: List[Int] = Nil
  //the cards in the set


  def addToCardset(input: Int) {
    //TODO: Test, dass man Werte zwischen 1und 10 und keine Redundanz
    println("Which card do you want to put next?")

    //if wrong userinput
    if (input < 1 || input > 10 || cardSet.contains(input) == true) {
       println("Fehleingabe vom User: Karte hat Wert 1-10, oder befindet sich bereits im Deck" +
        "..erhöhe sortingSteps")
    } else {
      cardSet = input :: cardSet
    }
  }


  def sortCardSet: Unit = {
   println("Which card do you want to put first?")
    while (cardSet.length < 10) {
      addToCardset(scala.io.StdIn.readInt())
      println(cardSet)
    }
  }
}
