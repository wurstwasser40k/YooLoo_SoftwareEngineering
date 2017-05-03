package de.htwg.se.yooloo.tui

import de.htwg.se.yooloo.model.{Player, PlayingField}

/**
  * Created by Vk on 16.04.2017.
  */

//TODO: Strings sammeln, und gebündelt als println ausgeben
/**
  * ***** Info ****
  * Tui is the concrete subject and has to implement Controller.update()
  * Observable.update() obtains state information from the subject and acts on that state
  * ****  Info ****
  */
object Tui extends App {

  var playingField = initPlayers()

  playingField.makeAMove(playingField.listPlayer)


  def initPlayers(): PlayingField = {
    println("Player 1 -")

    var player1 = new Player(enterPlayerName())
    println("Player 2 -")

    var player2 = new Player(enterPlayerName())
    println("Player 3 - ")

    var player3 = new Player(enterPlayerName())

    val listPlayer = List(player1, player2, player3)

    PlayingField(listPlayer)
  }


  def enterPlayerName(): String = {
    println("Enter your name: ")
    scala.io.StdIn.readLine()
  }

  def endOfRound(): Any = {

    println("The round is finished")


    playingField.listPlayer.foreach((player: Player) => println(player.namePlayer + " points for this round: " + player.pointsForOneRound))
    playingField.listPlayer.foreach((player: Player) => println(player.namePlayer + " total points: " + player.totalPoints))

    playingField.listPlayer.foreach((player: Player) => player.pointsForOneRound = 0)
    var input: Char = ' '

    do {
      println("Do you want to play another round - hit y for yes or n for no")
      try {
        input = scala.io.StdIn.readChar()
        input match {
          case 'n' => println("Thanks for playing YooLoo - Goodbye")
          case 'y' => playingField.makeAMove(playingField.listPlayer)
          case _ => println("wrong input - please type n or y")
        }
      } catch {
        case e: StringIndexOutOfBoundsException => println("Only hitting enter is not allowed as well")
        case e2: Exception => println("Other exception")

      }

    } while (input != 'n' && input != 'y')
  }

}