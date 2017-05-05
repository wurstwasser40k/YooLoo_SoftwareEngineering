import de.htwg.se.yooloo.model.{Player, PlayingField}
import de.htwg.se.yooloo.util.Observable

var cardset1 = List(1,2,3)
var cardset2 = List(2,1,4)

var p1 = new Player("Anton")
var p2 = new Player("benno")


var playingField = new PlayingField(List(p1, p2))

println(playingField.listPlayer)

val controller = new Controller(playingField)

println(controller.checkCardSet(2))

class Controller(playingField: PlayingField) extends Observable {
  def getCurrentPlayer: Player = playingField.currentPlayer

  def setCurrentPlayer(player: Player): Unit = playingField.currentPlayer = player

  def checkCardSet(input: Int): Boolean = {
    if (!getCurrentPlayer.cards.cardSet.contains(input) || getCurrentPlayer.cards.cardSet.length <= 10) {
      return true
    }
    false
  }

  def addCard(input: String): Unit = {
    //1. add to CardSet
    if (checkCardSet(input.toInt)) {
      getCurrentPlayer.cards.addToCardset(input.toInt)
    }

    notifyObservers

    //2. current Playerr
    if (getCurrentPlayer.cards.cardSet.length >= 10) {
      val myIndex = playingField.listPlayer.indexOf(getCurrentPlayer)
      if (myIndex <= playingField.listPlayer.length) setCurrentPlayer(playingField.listPlayer(myIndex + 1))
    }
  }
}

