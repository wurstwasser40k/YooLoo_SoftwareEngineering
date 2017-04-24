package de.htwg.se.yooloo.model


//change to playerList: List[Player]
case class PlayingField(listPlayer: List[Player]) {

  var pointsInThePot: Int = 0

  /**
    * One full move where the 10 cards are sorted and points are evaluated
    */
  def makeAMove(): Unit = {

    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    listPlayer.head.cards.sortCardSet

    listPlayer.foreach((player: Player) => (if (player != listPlayer.head) player.cards.sortCardSetAutomatically))

    evaluatePoints(listPlayer)

    endOfRound()

  }


  def evaluatePoints(listPlayer:List[Player]): Unit = {

    listPlayer.foreach((player: Player) => (println("Set from " +player.namePlayer+": "+player.cards.cardSet)))

    val cardSetLength:Int = listPlayer(0).cards.cardSet.length
    var i = 0
    //variable that runs through the arrays
    var pointValue = 1 //initially the point value is 1...then 2,3,...10
    while (i < cardSetLength) {

      pointsInThePot = pointsInThePot + pointValue
      decideWhoGetsThePoint(listPlayer, pointsInThePot, i)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      pointValue = pointValue + 1
      i = i + 1
    }
  }

  //decides who gets points
  def decideWhoGetsThePoint(listPlayer: List[Player], pointValue: Int, i: Int): Unit = {

    println("decideWhoGetsThePoint() startet jetzt")
    scala.io.StdIn.readLine()

    var currentListCards: List[Int] = Nil

    listPlayer.foreach((player: Player) => (currentListCards = (player.cards.cardSet(i)) :: currentListCards))
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

      listPlayer.foreach((player: Player) => (if (player.cards.cardSet(i) == largesVal) winner = player))
      winner.addPoints(pointValue)
      pointsInThePot = 0
    }

    /*case2: No winner
    add points to pot
     */
  }

  def endOfRound(): Any = {

    println("The round is finished")


    listPlayer.foreach((player: Player) => (println(player.namePlayer +" points for this round: " +player.pointsForOneRound)))
    listPlayer.foreach((player: Player) => (println(player.namePlayer +" total points: " +player.totalPoints)))

    listPlayer.foreach((player: Player) => (player.pointsForOneRound = 0))
    var input: Char = ' '

    do {
      println("Do you want to play another round - hit y for yes or n for no")
      try {
        input = scala.io.StdIn.readChar()
        input match {
          case 'n' => println("Thanks for playing YooLoo - Goodbye")
          case 'y' => makeAMove()
          case _ => println("wrong input - please type n or y")
        }
      } catch {
        case e: StringIndexOutOfBoundsException => println("Only hitting enter is not allowed as well")
        case e2: Exception => println("Other exception")

      }

    } while (input != 'n' && input != 'y')
  }
}
