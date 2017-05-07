package de.htwg.se.yooloo.model


//change to playerList: List[Player]
case class PlayingField() {

  var listPlayer: List[Player]=Nil
  var currentPlayer:Player = null
  var pointsInThePot: Int = 0

  /**
    * One full move where the 10 cards are sorted and points are evaluated
    */
  //Diese Methode verändert den Zustand von listPlayer! in Controller?
  /*
  def makeAMove(listPlayer: List[Player]): Unit = {

    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    listPlayer.head.cards.sortCardSet

    listPlayer.foreach((player: Player) => if (player != listPlayer.head) player.cards.sortCardSetAutomatically)

    evaluatePoints()

    listPlayer.foreach((player: Player) => player.pointsForOneRound = 0)
    //Tui.endOfRound()
  }
  */

  override def toString: String = {
    var myOutput=""

    listPlayer.foreach((player: Player) => myOutput= myOutput+""+player.namePlayer + ": " + player.cards.cardSet +"\n")
    myOutput
  }

  def evaluatePoints(): Unit = {

    listPlayer.foreach((player: Player) => println("Set from " + player.namePlayer + ": " + player.cards.cardSet))

    val cardSetLength: Int = listPlayer.head.cards.cardSet.length
    var i = 0
    //variable that runs through the arrays
    var pointValue = 1 //initially the point value is 1...then 2,3,...10
    while (i < cardSetLength) {

      pointsInThePot = pointsInThePot + pointValue
      decideWhoGetsThePoint(pointsInThePot, i)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      pointValue = pointValue + 1
      i = i + 1
    }
  }

  //decides who gets points
  def decideWhoGetsThePoint( pointValue: Int, i: Int): Unit = {

    println("decideWhoGetsThePoint() startet jetzt")
    scala.io.StdIn.readLine()

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
      println(currentListCards.max)
      var largesVal: Int = currentListCards.max
      var winner: Player = Player("")

      listPlayer.foreach((player: Player) => if (player.cards.cardSet(i) == largesVal) winner = player)
      winner.addPoints(pointValue)
      pointsInThePot = 0
    }

    /*case2: No winner
    add points to pot
     */
  }
}
