package uk.tldcode.games.dice

class D4 extends AbstractDie {
  def roll: Int = {
    random.nextInt(4) + 1
  }
}