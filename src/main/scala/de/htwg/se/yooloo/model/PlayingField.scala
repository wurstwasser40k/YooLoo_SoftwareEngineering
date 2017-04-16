package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
case class PlayingField (player1: Player,player2: Player, player3: Player ) {

  private var nobodyWon = false




  /**
    * Every player sorts his cardSet
    */
  def makeAMove(set1: CardSet, set2: CardSet,set3: CardSet): Unit = {


    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    println("Player 1 - sort your cardDeck")
    set1.sortCardSet

/**    println("Player 2 - sort your cardDeck")
    set2.sortCardSetAutomatically

    println("Player 3 - sort your cardDeck")
    set3.sortCardSetAutomatically


    println("Set1:"+set1.cardSet )
    println("Set2:" + set2.cardSet )
    println("Set3:" + set3.cardSet )

    //convert Lists to Array, because accessing a value in an array is way more comfortable
    val set1Array: Array[Int] = (set1.cardSet).toArray
    val set2Array: Array[Int] = (set2.cardSet).toArray
    val set3Array: Array[Int] = (set3.cardSet).toArray





    //3 possibilities:
    // A)One card is the highest --> winner is clear
    // B)2 Players have the highest (equal) card, e.g. both have an 8, while the third player has a 6 -->
    //

    var i = 0  //variable that runs through the arrays
    var pointValue =1 //initially the point value is 1...then 2,3,...10
    while(i<=9){

      if(nobodyWon==true){


        val cumulatedPointvalue=pointValue+pointValue-1
        decideWhoGetsThePoint(set1Array(i),set2Array(i),set3Array(i),cumulatedPointvalue:Int)
        nobodyWon=false
      }else{
        decideWhoGetsThePoint(set1Array(i),set2Array(i),set3Array(i),pointValue:Int)
      }



      pointValue=pointValue+1
      i=i+1
    }




    //3 possibilities:
    // A)One card is the highest --> winner is clear
    // B)2 Players have the highest (equal) card, e.g. both have an 8, while the third player has a 6 -->
    //






    //TODO: Implement Method
    //calls method addPoints()
    //the class has to know how many points are in the pot
  }



  def decideWhoGetsThePoint(card1: Int, card2: Int, card3: Int, pointValue:Int) = {

    //case 1: One player clearly wins the round
    if(card1>card2 && card1 > card3){
      player1.addPoints(pointValue)
    }
    if(card2>card1 && card2 > card3){
      player2.addPoints(pointValue)
    }
    if(card3>card1 && card3 > card2){
      player3.addPoints(pointValue)
    }

    //case2: 2 equal cards and one which is lower -> lower cards wins
    if(card1==card2 && card1>card3){
      player3.addPoints(pointValue)
    }
    if(card1==card3 && card1>card2){
      player2.addPoints(pointValue)
    }
    if(card3==card2 && card3>card1){
      player1.addPoints(pointValue)
    }

    //case3: all cards are equal -> nobody wins..points are added up
    if(card1==card2==card3){
      nobodyWon=true
      println("nobody won this round - points should add up")
    }
  **/


  }




  def playOneRound: Unit = {
    //TODO: Ruft zehn mal über eine for/foreach die Methode makeAMove() auf
  }
}
