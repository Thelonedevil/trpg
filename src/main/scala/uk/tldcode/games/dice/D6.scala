package uk.tldcode.games.dice

class D6 extends AbstractDie {
  def roll: Int = {
    random.nextInt(6) + 1
  }
}