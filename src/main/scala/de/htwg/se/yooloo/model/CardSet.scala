package de.htwg.se.yooloo.model

import scala.util.Random

/**
  * Created by svenb on 29.03.2017.
  */

case class CardSet() {

  var cardSet: List[Int] = Nil
  //the cards in the set


  def addToCardset(input: Int) {
    //TODO: Test, dass man Werte zwischen 1und 10 und keine Redundanz



    //if wrong userinput
    if (input <= 0 || input >= 11 || cardSet.contains(input) == true) {
      println("Wrong User-Input: Card has to be between 1-10, or the card you wanted to add is already " +
        " is already inside your cardset -> Choose another card!")

    } else {
      cardSet = input :: cardSet
      println("Your current cardSet: "+cardSet)
      if(cardSet.length <= 8){
        println("Which card do you want to put next?")
      }

    }
  }


  def sortCardSet: Unit = {
    println("Which card do you want to put first?")

    while (cardSet.length <= 9) {


      try{
      val input = scala.io.StdIn.readInt()
      addToCardset(input)

      }
      catch{
        case e: NumberFormatException => println("You have to  type an Int-value...String is not allowed")
        case oe: Exception => println("Other Exception")
      }
    }
  }


  /**
    * In case we want to implememt an AI, this method sorts the cardDeck
    */
  def sortCardSetAutomatically: Unit = {

    val myRandStream = new Random()






    while (cardSet.length <= 9) {


      try{
        val input =  myRandStream.nextInt(11)
        addToCardset(input)

      }
      catch{
        case e: NumberFormatException => println("You have to  type an Int-value...String is not allowed")
        case oe: Exception => println("Other Exception")
      }
    }





  //  if(myRandStream.nextDouble()>=0.5){
    //     cardSet = 10 :: 9 :: 8 :: 7 :: 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: cardSet
    //  }
    //  if(myRandStream.nextDouble()<=0.5 ){
    //   cardSet = 7 :: 8 :: 9 :: 10 :: 6 :: 5 :: 4 :: 1 :: 2 :: 3 :: cardSet
    //  }

    println(this.toString +"has been sorted automatically")


  }


}
