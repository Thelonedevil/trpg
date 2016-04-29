package uk.tldcode.games.engine

import uk.tldcode.games.character.Character

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait Turn {
  private[engine] val order: mutable.PriorityQueue[Character] = new mutable.PriorityQueue[Character]
  private[engine] val players: ListBuffer[Character] = new ListBuffer[Character]
  private[engine] val enemies: ListBuffer[Character] = new ListBuffer[Character]
  private[engine] val ttype = ""

  private[engine] def nextTurn(): Unit

  private[games] def start(): Unit
}
