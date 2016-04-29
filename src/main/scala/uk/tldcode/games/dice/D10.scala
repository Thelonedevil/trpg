package uk.tldcode.games.dice

class D10 extends AbstractDie {
  def roll: Int = {
    random.nextInt(10)
  }
}