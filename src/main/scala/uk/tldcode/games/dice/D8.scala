package uk.tldcode.games.dice

class D8 extends AbstractDie {
  def roll: Int = {
    random.nextInt(8) + 1
  }
}