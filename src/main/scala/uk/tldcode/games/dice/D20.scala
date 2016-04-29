package uk.tldcode.games.dice

class D20 extends AbstractDie {
  def roll: Int = {
    random.nextInt(20) + 1
  }
}