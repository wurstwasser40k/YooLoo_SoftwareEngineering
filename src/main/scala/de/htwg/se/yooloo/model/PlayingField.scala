package de.htwg.se.yooloo.model


//change to playerList: List[Player]
case class PlayingField(numCards:Int) {

  var listPlayer: List[Player]=Nil
  var currentPlayer:Player = null
  var pointsInThePot: Int = 0
  var finishedRound = false
  var pointValue = 1



  override def toString: String = {
    var myOutput=""

    listPlayer.foreach((player: Player) => myOutput= myOutput+"PlayerName: "+player.namePlayer + " has Cardset: " + player.cards.cardSet
      +",pointsForOneRound: " + player.pointsForOneRound  + ",totalPoints: "+ player.totalPoints +"\n")
    myOutput
  }



  //decides who gets points
  def decideWhoGetsThePoint( pointValue: Int, i: Int): Unit = {

    var currentListCards: List[Int] = Nil

    listPlayer.foreach((player: Player) => currentListCards = player.cards.cardSet(i) :: currentListCards)
    var dupCards: List[Int] = Nil
    dupCards = currentListCards

    //new List contains only the duplicate(s)
    dupCards = dupCards.diff(dupCards.distinct).distinct

    //filter duplicated values from currentListCards
    currentListCards = currentListCards.filterNot(dupCards.toSet)

    /*case1: winner:
    - call addPoints
    - reset pot points
     */
    if (currentListCards != Nil) {
      //find largest Int-Value

      var largesVal: Int = currentListCards.max
      var winner: Player = Player("",numCards)

      listPlayer.foreach((player: Player) => if (player.cards.cardSet(i) == largesVal) winner = player)
      winner.addPoints(pointValue)
      pointsInThePot = 0
    }

    /*case2: No winner
    add points to pot
     */
  }
}
