package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.controller.Impl.Controller
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {

  "A Controller" when {
    var controller = new Controller(List((new PlayerFactory).create(null)), new PlayerFactory, new CardsFactory, 3, 3)

    "empty " should {
      "have max amount of player " in {
        controller.getAmountOfMaxPlayers should be(3)
      }
      "should have a certain amount of cards" in {
        controller.getAmountOfCards should be(3)
      }
    }
    "adding a player" should {
      controller.addPlayer("Viktoria")

      "add player to list of player" in {
        controller.players.toString() should be("List(Name: Viktoria)")
      }
    }
    "setting current player " should {
      "initially be no player " in {
        controller.getNameCurrentPlayer() should be(null)
      }


      "be the next player in list" when {
        "size of current players is > 1" in {
          controller.addPlayer("Sven")
          controller.players.size should be(2)
          controller.setCurrentPlayer()
          controller.getNameCurrentPlayer() should be("Sven")
          controller.getIndexCurrentPlayer should be(0)
          controller.getI should be(0)
        }
      }
    }

    "adding cards to player" should {
      "add cards to current player" in {
        controller.players.head.cards should be(null)
        controller.addCard(3)
        controller.players.head.cards.toString should be("3 | ")
        controller.addCard(2)
        controller.players.head.cards.toString should be("2 | 3 | ")
        controller.addCard(3)
        controller.players.head.cards.toString should be("2 | 3 | ")
        controller.addCard(20)
        controller.players.head.cards.toString should be("2 | 3 | ")
        controller.addCard(1)
        controller.players.head.cards.toString should be("1 | 2 | 3 | ")
      }
    }

    "changing current player" should {
      "set the next player in list to current player" in {
        controller.getNameCurrentPlayer() should be("Sven")
        controller.changeCurrentPlayer()
        controller.getNameCurrentPlayer() should be("Viktoria")
      }
    }

    "adding cards to next player in list" should {
      "add cards to the new current player" in {
        controller.players(1).cards should be(null)
        controller.addCard(2)
        controller.players(1).cards.toString should be("2 | ")
        controller.addCard(3)
        controller.players(1).cards.toString should be("3 | 2 | ")
        controller.addCard(3)
        controller.players(1).cards.toString should be("3 | 2 | ")
        controller.addCard(1)
        controller.players(1).cards.toString should be("1 | 3 | 2 | ")
      }
    }

    "changing player to next player when there is no next item in list" should {
      "not change current player to next player" in {
        controller.getNameCurrentPlayer() should be("Viktoria")
        controller.changeCurrentPlayer()
        controller.getNameCurrentPlayer() should be("Viktoria")
      }
    }

    "evaluating players cards for the first time " should {
      "get the correct sum of points" in {
        controller.players.head.pointsForOneRound should be(0)
        controller.players.head.totalPoints should be(0)
        controller.getI should be(0)
        controller.pointValue should be(1)
        controller.evaluatePoints()
        controller.getI should be(1)
        controller.players.head.pointsForOneRound should be(0)
        controller.players(1).pointsForOneRound should be(0)
        controller.pointsInThePot should be(1)
        controller.pointValue should be(2)
        controller.evaluatePoints()
        controller.getI should be(2)
        controller.players.head.pointsForOneRound should be(0)
        controller.players(1).pointsForOneRound should be(3)
        controller.pointsInThePot should be(0)
        controller.evaluatePoints()
        controller.getI should be(3)
        controller.players.head.pointsForOneRound should be(3)
        controller.players(1).pointsForOneRound should be(3)
      }
    }

    "a new round starts" should {
      "reset cards of each player" in {
        controller.newRoundStarted()
        controller.players(1).cards should be(null)
        controller.players.head.cards should be(null)
      }
      "not change total points of each player" in {
        controller.players.head.totalPoints should be(3)
        controller.newRoundStarted()
        controller.players.head.totalPoints should be(3)
      }
    }
    "exit" should {
      "finish to game" in {
        controller.exit() should be(0)
      }
    }
  }
}