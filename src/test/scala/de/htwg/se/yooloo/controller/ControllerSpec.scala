package de.htwg.se.yooloo.controller

import de.htwg.se.yooloo.controller.Impl.Controller
import de.htwg.se.yooloo.model.Impl.{CardsFactory, PlayerFactory}
import org.scalatest.{Matchers, WordSpec}

class ControllerSpec extends WordSpec with Matchers {

  "A Controller" when {
    var controller = new Controller(List((new PlayerFactory).create(null)), new PlayerFactory, new CardsFactory,4,5)

    "adding a player" should {
      val player = new PlayerFactory().create("Viktoria")
      controller.addPlayer("Viktoria")

      "add player to List of player" in {
        controller.players.toString() should be("List(Name: Viktoria)")
      }
    }
    "setting current player " should {
      "initially be no player " in {
        controller.getNameCurrentPlayer() should be(null)
      }

      "be the first player in list" when {
        "size of current players is > 2" in {
          controller.addPlayer("Sven")
          controller.players.size should be (2)
          controller.setCurrentPlayer()
          controller.getNameCurrentPlayer() should be ("Sven")
          controller.getIndexCurrentPlayer
          controller.getIndexCurrentPlayer should be (0)
        }
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
}