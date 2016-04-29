package uk.tldcode.games.character

import uk.tldcode.games.action.Action
import uk.tldcode.games.dice.Die

trait Character extends Comparable[Character] {
  private[games] val d4: Die
  private[games] val d6: Die
  private[games] val d8: Die
  private[games] val d10: Die
  private[games] val d10L: Die
  private[games] val d12: Die
  private[games] val d20: Die
  private[games] val d20S: Die
  private[games] val d100: Die

  def getCurrentOrder: Int

  def rollForOrder: Int

  def getName: String

  def getHealth: Int

  def getStats: Stat

  def damage(amount: Int): Unit

  def chooseAction: Action
}
