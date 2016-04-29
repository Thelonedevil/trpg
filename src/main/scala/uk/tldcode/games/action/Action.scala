package uk.tldcode.games.action

import uk.tldcode.games.character.Character

trait Action {
  def perform(character1: Character, character2: Character): Unit

  val name: String
  val description: String
}

abstract class CombatAction(override val name: String, override val description: String) extends Action {
}

object Punch extends CombatAction("Punch", "Punch Enemy") {
  override def perform(character1: Character, character2: Character): Unit = {
    var roll = character1.d10.roll
    val dex = character1.getStats.dexterity % 5
    println(s"Dex Rolled: $roll")
    println(s"Needed to Roll: $dex")
    if (roll > dex) {
      roll = character1.d4.roll
      val str = Math.floor(character1.getStats.strength*(roll/4.0)).toInt
      println(s"Str Rolled: $roll")
      println(s"Damage Dealt: $str")
      character2.damage(str)
      println(s"Punched ${character2.getName}")
      println(s"${character2.getName} is now at ${character2.getHealth}")
    } else {
      println(s"Missed ${character2.getName}")
    }
  }
}
