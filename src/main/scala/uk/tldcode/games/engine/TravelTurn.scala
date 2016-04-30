package uk.tldcode.games.engine

import uk.tldcode.games.character.Character

class TravelTurn (override val characters: Seq[_ <: Character]) extends AbstractTurn(characters = characters){
  override private[engine] def nextTurn(): Unit = ???
}
