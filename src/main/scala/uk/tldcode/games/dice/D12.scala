package uk.tldcode.games.dice

class D12 extends AbstractDie {
  def roll: Int = {
    random.nextInt(12) + 1
  }
}