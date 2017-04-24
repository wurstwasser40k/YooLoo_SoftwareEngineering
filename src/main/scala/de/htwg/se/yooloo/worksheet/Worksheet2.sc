
case class Player(namePlayer: String) {
  var cards = new CardSet
}

class CardSet {
  var cardSet: List[Int] = Nil
}

var set1 = List(1, 2)
var set2 = List(2, 3)
var set3 = List(4, 4)

var player1 = Player("AnnA")
var player2 = Player("BennO")
var player3 = Player("Caesar")


player1.cards.cardSet = set1
player2.cards.cardSet = set2
player3.cards.cardSet = set3
var listPlayer: List[Player] = List(player1, player2)

/*
1. Add Card [aktueller Index] of each Player to a List (Reihenfolge wichtig!)
2. Remove duplicates from List -->welche Collection? vielleicht Seq?
3. The existing player with highest value wins
4. Nobody wins
 */

var currentListCards: List[Int] = Nil

listPlayer.foreach((player: Player) => (currentListCards = (player.cards.cardSet(0)) :: currentListCards))

var dupCards: List[Int] = Nil
dupCards = currentListCards

//new List contains only the duplicate(s)
dupCards = dupCards.diff(dupCards.distinct).distinct

//filter duplicated values from currentListCards
currentListCards = currentListCards.filterNot(dupCards.toSet)

//find largest Int-Value

/*case1: winner:
- call addPoints
- reset pot points
 */
if (currentListCards != Nil) {
  //find largest Int-Value
  println(currentListCards.max)
  var largesVal: Int = currentListCards.max
  var winner:Player = Player("")

  listPlayer.foreach((player: Player) => (if (player.cards.cardSet(0) == largesVal) winner = player))
  println(winner.namePlayer)
}






/*case2: No winner
add points to pot
 */
