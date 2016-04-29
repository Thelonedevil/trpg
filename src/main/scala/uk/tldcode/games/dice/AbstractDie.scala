package uk.tldcode.games.dice

import java.util.Random

abstract class AbstractDie extends Die {
  protected var random: Random = new Random
}