package uk.tldcode.games.dice

class D10L extends D10 {
  override def roll: Int = {
    super.roll * 10
  }
}