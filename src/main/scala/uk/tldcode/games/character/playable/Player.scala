package uk.tldcode.games.character.playable

import uk.tldcode.games.action.Punch
import uk.tldcode.games.character.{AbstractCharacter, Stat}

class Player(name: String, stats: Stat) extends AbstractCharacter(name, stats) {
  actions.append(Punch)
}