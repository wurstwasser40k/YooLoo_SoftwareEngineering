package de.htwg.se.yooloo.model

/**
 * Created by svenb on 29.03.2017.
 */
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

  /**
   * Evaluates the points for 3 cardsets for each of the 10 cards
   * Prints out something like:
   * "Player(b) receives 1 points"
   * "Player(a) receives 2 points"
   * ...
   * "Player(c) receives 10 points"
   *
   * @param set1
   * @param set2
   * @param set3
   */
  def evaluatePoints(set1: List[Int], set2: List[Int], set3: List[Int]) = {

    println("Set1:" + set1)
    println("Set2:" + set2)
    println("Set3:" + set3)

    //convert Lists to Array, because accessing a value in an array is way more comfortable
    val set1Array: Array[Int] = (set1).toArray
    val set2Array: Array[Int] = (set2).toArray
    val set3Array: Array[Int] = (set3).toArray

    var i = 0 //variable that runs through the arrays
    var pointValue = 1 //initially the point value is 1...then 2,3,...10
    while (i <= 9) {

      pointsInThePot = pointsInThePot + pointValue
      decideWhoGetsThePoint(set1Array(i), set2Array(i), set3Array(i), pointsInThePot)

      //first pointValue = 1, second pointValue = 2,..., last pointValue=10
      pointValue = pointValue + 1
      i = i + 1
    }

  }

  /**
   * Takes 3 cards into account and decides which card wins.
   * In case there is a clear winner --> the respective player gets the respective amount of points
   * and the variable pointsInThePott is set  to 0 again.
   * In case there is no winner the variable pointsInThePott is not set to 0...so the amount of points in the next
   * round will be higher (c.f. method evaluatePoints)
   *
   * @param card1
   * @param card2
   * @param card3
   * @param pointValue
   */
  def decideWhoGetsThePoint(card1: Int, card2: Int, card3: Int, pointValue: Int) = {

    println("Player 1 has card value " + card1 + " Player 2 has card value " + card2 + " Player 3 has card " + card3)
    println("Press any key")
    scala.io.StdIn.readLine()

    //case 1: One player clearly wins the round
    if (card1 > card2 && card1 > card3) {
      player1.addPoints(pointValue)
      pointsInThePot = 0
    }
    if (card2 > card1 && card2 > card3) {
      player2.addPoints(pointValue)
      pointsInThePot = 0
    }
    if (card3 > card1 && card3 > card2) {
      player3.addPoints(pointValue)
      pointsInThePot = 0
    }

    //case2: 2 equal cards and one which is lower -> lower cards wins
    if (card1 == card2 && card1 > card3) {
      player3.addPoints(pointValue)
      pointsInThePot = 0
    }
    if (card1 == card3 && card1 > card2) {
      player2.addPoints(pointValue)
      pointsInThePot = 0
    }
    if (card3 == card2 && card3 > card1) {
      player1.addPoints(pointValue)
      pointsInThePot = 0
    }

    //case3: all cards are equal -> nobody wins..points are added up
    if (card1 == card2 && card2 == card3) {
      println("nobody won this round - points should add up")
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
