package uk.tldcode.games.character

import java.util.Scanner

import uk.tldcode.games.InputUtil
import uk.tldcode.games.action.Action
import uk.tldcode.games.dice._

import scala.collection.mutable.ArrayBuffer

abstract class AbstractCharacter(var name: String, var statistics: Stat) extends Character {
  private[games] val d4: Die = new D4
  private[games] val d6: Die = new D6
  private[games] val d8: Die = new D8
  private[games] val d10: Die = new D10
  private[games] val d10L: Die = new D10L
  private[games] val d12: Die = new D12
  private[games] val d20: Die = new D20
  private[games] val d20S: Die = new D20S
  private[games] val d100: Die = new D100
  private var currentOrder: Int = 0
  private[character] val actions = new ArrayBuffer[Action]
  private var health: Int = Math.pow(getStats.constitution,1.2).toInt

  def rollForOrder: Int = {
    currentOrder = d20.roll
    currentOrder
  }

  def getName: String = {
    name
  }

  def getCurrentOrder: Int = {
    currentOrder
  }

  def compareTo(character: Character): Int = {
    if (getCurrentOrder < character.getCurrentOrder) -1
    else if (getCurrentOrder == character.getCurrentOrder) 0
    else 1
  }

  def getStats: Stat = {
    statistics
  }

  def getHealth: Int = {
    health
  }
  override def damage(amount:Int): Unit ={
    health -= amount
  }

  def chooseAction: Action = {
    val message = StringBuilder.newBuilder
    message.append("Choose an action to perform:\n")
    for ((action, i) <- actions.view.zipWithIndex) {
      {
        message.append(i + ": " + action.name + " -> " + action.description + "\n")
      }

    }
    var input: String = "NOTANINTEGER"
      while (!InputUtil.isInteger(input)) {
        {
          println(message)
          input = InputUtil.scanner.nextLine
        }
      }
    actions.toArray.apply(input.toInt)
  }
}