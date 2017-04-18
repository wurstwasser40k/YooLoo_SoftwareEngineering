package de.htwg.se.yooloo.model

import org.scalatest.{ Matchers, WordSpec }

/**
 * Created by svenb on 17.04.2017.
 */
class PlayingFieldSpec extends WordSpec with Matchers {

  //initialization for testing purposes
  val player1 = new Player("A")
  val player2 = new Player("B")
  val player3 = new Player("C")

  val set1 = CardSet()
  val set2 = CardSet()
  val set3 = CardSet()

  val playingField = PlayingField(player1, player2, player3)

  "Calling makeAMove for " +
    "set1.cardSet=List(5,4,3,2,1,10,9,8,7,6)" +
    "set2.cardSet=List(5,4,3,2,1,10,9,8,7,6)" +
    "set3.cardSet=List(5,10,1,2,3,4,6,8,7,9)" should {
      "result in  55 points for the third player C while player1 and 2 have 0 points" in {

        set1.cardSet = List(5, 4, 3, 2, 1, 10, 9, 8, 7, 6)
        set2.cardSet = List(5, 4, 3, 2, 1, 10, 9, 8, 7, 6)
        set3.cardSet = List(5, 10, 1, 2, 3, 4, 6, 8, 7, 9)
        playingField.makeAMove()

        player1.totalPoints should be(0)
        player2.totalPoints should be(0)
        player3.totalPoints should be(55)

      }
    }

  "Calling decideWhoGetsThePoint(5,3,2,5) " should {
    "result in  5 points  points for the first player A" in {

      player1.totalPoints = 0
      player2.totalPoints = 0
      player3.totalPoints = 0

      playingField.decideWhoGetsThePoint(5, 3, 2, 5)

      player1.totalPoints should be(5)
      player2.totalPoints should be(0)
      player3.totalPoints should be(0)


    }

  }

  "Calling decideWhoGetsThePoint(4,4,4,5)   " should {
    "result in 0 points for all players " in {

      player1.totalPoints = 0
      player2.totalPoints = 0
      player3.totalPoints = 0

      playingField.decideWhoGetsThePoint(4, 4, 4, 5)

      player1.totalPoints should be(0)
      player2.totalPoints should be(0)
      player3.totalPoints should be(0)

    }
  }

  "Calling decideWhoGetsThePoint(4,4,3,10)   " should {
    "result in 10 points for player3 " in {

      player1.totalPoints = 0
      player2.totalPoints = 0
      player3.totalPoints = 0

      playingField.decideWhoGetsThePoint(4, 4, 3, 10)

      player1.totalPoints should be(0)
      player2.totalPoints should be(0)
      player3.totalPoints should be(10)

    }
  }

}
