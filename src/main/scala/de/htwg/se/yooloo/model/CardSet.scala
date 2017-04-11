package de.htwg.se.yooloo.model

/**
  * Created by svenb on 29.03.2017.
  */

case class CardSet() {

  var cardSet: List[Int] = Nil
  //the cards in the set
  var sortingSteps = 10


  def addToCardset(input: Int) {
    //TODO: Test, dass man Werte zwischen 1und 10 und keine Redundanz
    println("Which card do you want to put next?")

    // require(input<=10,"User has to choose a card between 1 and 10")
    // require(input>=1,"User has to choose a card between 1 and 10")
    // require(cardSet.distinct == cardSet, "cardSet must not contain dupolicate cards")

    //if wrong userinput --> add another sortingSet
    if (input < 1 || input > 10 || cardSet.contains(input) == true) {
      sortingSteps = sortingSteps + 1
      print("Fehleingabe vom User: Karte hat Wert 1-10, oder befindet sich bereits im Deck" +
        "..erhöhe sortingSteps" + sortingSteps)
    } else {
      cardSet = input :: cardSet
    }


  }


  def sortCardSet: Unit = {
    for {
      n <- 1.to(sortingSteps)
    } addToCardset(scala.io.StdIn.readInt())
  }


}
