package de.htwg.se.yooloo.model

/**
  * Created by svenb on 29.03.2017.
  */
case class PlayingField(playerList: List[Player]) {

  var pointsInThePot: Int = 0


  /**
    * One full move where the 10 cards are sorted and points are evaluated
    */
  def makeAMove(): Unit = {

    println("Test")
    playerList.foreach(i=>println(i))



  }

}

case class StartPlayer(){



val player1 = Player("A")
  val player2 = Player("A")
  val player3 = Player("A")

val myPlayerList = List(player1,player2,player3)

var playingField = new PlayingField(myPlayerList)
  playingField.makeAMove()
}