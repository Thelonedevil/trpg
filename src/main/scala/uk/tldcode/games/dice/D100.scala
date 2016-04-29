package uk.tldcode.games.dice

class D100 extends AbstractDie {
  def roll: Int = {
    random.nextInt(100)
  }
}