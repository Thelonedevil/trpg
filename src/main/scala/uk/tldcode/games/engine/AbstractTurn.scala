package uk.tldcode.games.engine

import uk.tldcode.games.character.nonplayable.Enemy
import uk.tldcode.games.character.playable.Player
import uk.tldcode.games.character.Character

abstract class AbstractTurn(val characters: Seq[_ <: Character]) extends Turn {
  characters.foreach(c => {
    c.rollForOrder
    order+=c
    c match {
      case _: Player =>
        players+=c
      case _: Enemy =>
        enemies+=c
      case _ =>
    }
    order
  })

  private[games] def start() :Unit={
    while(enemies.forall(c=>c.getHealth > 0)) {
      nextTurn()
    }
  }

  private[games] def setPlayers(players:Seq[Player]):Unit={
    players.foreach(p=>this.players+=p)
  }
}
