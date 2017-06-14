package de.htwg.se.yooloo.model.Impl

import org.scalatest.{Matchers, WordSpec}

class PlayerSpec extends WordSpec with Matchers {

  "A Player" when {
    "empty" should {
      val player: Player = null
      "throw a java.lang.NullPointerException" in {
        assertThrows[java.lang.NullPointerException] {
          player.toString
        }
      }
    }
  }
  "Creating a player" when {
    "starting the game" in {
      new Player("Hannelore") should be(Player("Hannelore", null, 0, 0))
    }
    "adding the cards" in {
      new Player("Heino", Cards(List(1)), 0) should be(Player("Heino", Cards(List(1)), 0, 0))
    }
    "evaluate the points" in {
      new Player("A", Cards(List(1)), 0, 0) should be(Player("A", Cards(List(1)), 0, 0))
    }
    "starting a new round" in {
      new Player("a", 3) should be(Player("a", null, 0, 3))
    }
  }
  val player = new Player("Ann", Cards(List(1, 2, 3)), 0)
  "Adding points to player" in {
    player.addPoints(3, 1) should be(Player("Ann", Cards(List(1, 2, 3)), 3, 1))
  }

  "Creating player toString" in {
    player.toString should be("Name: Ann")
  }
}