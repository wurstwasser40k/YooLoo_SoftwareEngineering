package de.htwg.se.yooloo.model


//change to playerList: List[Player]
case class PlayingField(player1: Player, player2: Player, player3: Player) {

  var pointsInThePot: Int = 0

  /**
    * One full move where the 10 cards are sorted and points are evaluated
    */
  def makeAMove(): Unit = {

    val set1 = player1.cards
    val set2 = player2.cards
    val set3 = player3.cards

    //Sort the cardsets for each player (player 1 manually, 2 and 3 do it automatically)
    println("Player 1 - sort your cardDeck")
    set1.sortCardSet

    println("Player 2 - sort your cardDeck")
    set2.sortCardSetAutomatically

    println("Player 3 - sort your cardDeck")
    set3.sortCardSetAutomatically

    evaluatePoints(player1.cards.cardSet, set2.cardSet, set3.cardSet)

    endOfRound()

  }


  def evaluatePoints(set1: List[Int], set2: List[Int], set3: List[Int]) = {


    println("Set1:" + set1)
    println("Set2:" + set2)
    println("Set3:" + set3)

    //convert Lists to Array, because accessing a value in an array is way more comfortable
    val set1Array: Array[Int] = (set1).toArray
    val set2Array: Array[Int] = (set2).toArray
    val set3Array: Array[Int] = (set3).toArray

    var i = 0
    //variable that runs through the arrays
    var pointValue = 1 //initially the point value is 1...then 2,3,...10
    while (i <= 9) {

      pointsInThePot = pointsInThePot + pointValue
      //Added hilfsliste
      val listPlayer: List[Player] = List(player1, player2, player3)
      decideWhoGetsThePoint(listPlayer, pointsInThePot, i)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      pointValue = pointValue + 1
      i = i + 1
    }

  }

  //decides who wins
  def decideWhoGetsThePoint(listPlayer: List[Player], pointValue: Int, i: Int) = {

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
    else {

    }


  }

  def endOfRound() = {

    println("The round is finished")
    println(player1.namePlayer + " has total points:" + player1.totalPoints + " ...and for this specific round: " + player1.pointsForOneRound)
    println(player2.namePlayer + " has total points:" + player2.totalPoints + " ...and for this specific round: " + player2.pointsForOneRound)
    println(player3.namePlayer + " has total points:" + player3.totalPoints + " ...and for this specific round: " + player3.pointsForOneRound)

    player1.pointsForOneRound = 0
    player2.pointsForOneRound = 0
    player3.pointsForOneRound = 0

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

  def playOneRound: Unit = {
    //TODO: Ruft zehn mal über eine for/foreach die Methode makeAMove() auf
  }
}
