package de.htwg.se.yooloo.model

//TODO: Variable Anzahl Spieler soll möglich sein. zahl im Konstruktor übergeben
class PlayerCreator () {

  def initPlayers: List[Player] = {

    println("Player 1 -")
    var player1 = new Player(enterPlayerName())

    println("Player 2 -")
    var player2 = new Player(enterPlayerName())

    println("Player 3 - ")
    var player3 = new Player(enterPlayerName())

    //listPlayer muss in das Objekt Controller gespeichert weden!
    val listPlayer = List(player1, player2, player3)

    listPlayer
  }


  def enterPlayerName(): String = {
    println("Enter your name: ")
    scala.io.StdIn.readLine()
  }
}
