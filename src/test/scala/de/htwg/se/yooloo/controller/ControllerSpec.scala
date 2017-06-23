package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.controller.Impl.Controller
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {

  "A Controller" when {
    var controller = new Controller(List((new PlayerFactory).create(null)), new PlayerFactory, new CardsFactory)

    "adding a player" should {
      val player = new PlayerFactory().create("Viktoria")
      controller.addPlayer("Viktoria")
      "add player to List of player" in {
        controller.players.toString() should be("List(Name: Viktoria)")
      }
    }
    "setting current player " should{

    }
    /*
    "notify its Observer after card current player was set" in {
    }
    "notify its Observer after card was added" in {
    }
    "notify its Observer after move was evaluated" in {
    }
    "notify its Observer after round was evaluated" in {
    }
    */
  }
}


/*


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

      playingField.decideWhoGetsThePoint(3, 2, 5)

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

      playingField.decideWhoGetsThePoint( 4, 4, 5)

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

      playingField.decideWhoGetsThePoint(4, 3, 10)

      player1.totalPoints should be(0)
      player2.totalPoints should be(0)
      player3.totalPoints should be(10)

    }
  }
  */
