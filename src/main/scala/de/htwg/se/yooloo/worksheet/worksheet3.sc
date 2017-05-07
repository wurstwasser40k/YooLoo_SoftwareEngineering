import de.htwg.se.yooloo.controller.Controller
import de.htwg.se.yooloo.model.{Player, PlayingField}

var playingField = new PlayingField

var controller = new Controller(playingField)

controller.initPlayer("a")

println(playingField.listPlayer)



def initPlayer(input: String): Unit = {
  playingField.listPlayer = new Player(input) :: playingField.listPlayer //TODO: mit copy lösen, derzeit ist listPlayer in PlayingField eine var!!!

  //set current player after initial input
  if(playingField.listPlayer.length==1){setCurrentPlayer(playingField.listPlayer(0))}


}

def setCurrentPlayer(player: Player): Unit = playingField.currentPlayer = player

