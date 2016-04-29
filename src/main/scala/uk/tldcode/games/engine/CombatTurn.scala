package uk.tldcode.games.engine

import uk.tldcode.games.InputUtil
import uk.tldcode.games.character.Character
import uk.tldcode.games.character.nonplayable.Enemy
import uk.tldcode.games.character.playable.Player

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, PriorityQueue}
import scala.util.Random


class CombatTurn( override val characters: Seq[_ <: Character]) extends AbstractTurn(characters = characters) {

  def nextTurn(): Unit = {
    val tempOrder: mutable.PriorityQueue[Character] = new mutable.PriorityQueue[Character]
    tempOrder++=order
    order.foreach(c=>println(c.getName+"\t"+c.getHealth))
    while (tempOrder.nonEmpty) {
      {
        val character: Character = tempOrder.dequeue()
        if (players.contains(character)) {
          val action = character.chooseAction
          val message = StringBuilder.newBuilder
          if(enemies.size > 1) {
            message.append("Choose an enemy to hit:\n")
            for ((enemy, i) <- enemies.view.zipWithIndex) {
              {
                message.append(i + ": " + enemy.getName + " -> " + enemy.getHealth + "\n")
              }
            }
            var input: String = "NOTANINTEGER"


            while (!InputUtil.isInteger(input)) {
              {
                println(message)
                input = InputUtil.scanner.nextLine
              }
            }

            action.perform(character, enemies.toArray.apply(input.toInt))
          }else{
            action.perform(character,enemies.toArray.apply(0))
          }
        }
        else if (enemies.contains(character)) {
          val playerList: ListBuffer[Character] = new ListBuffer[Character]
          playerList++=players
          val c: Character = playerList.apply(new Random().nextInt(playerList.size))
        }

      }
    }
  }
}