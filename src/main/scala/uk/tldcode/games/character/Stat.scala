package uk.tldcode.games.character

object Stat {

  class Builder {
    private[tldcode] var strength: Int = 0
    private[tldcode] var constitution: Int = 0
    private[tldcode] var dexterity: Int = 0
    private[tldcode] var intelligence: Int = 0
    private[tldcode] var wisdom: Int = 0
    private[tldcode] var charisma: Int = 0

    def build: Stat = {
      new Stat(this)
    }

    def setStrength(strength: Int): Builder = {
      this.strength = strength
      this
    }

    def setConstitution(constitution: Int): Builder = {
      this.constitution = constitution
      this
    }

    def setDexterity(dexterity: Int): Builder = {
      this.dexterity = dexterity
      this
    }

    def setIntelligence(intelligence: Int): Builder = {
      this.intelligence = intelligence
      this
    }

    def setWisdom(wisdom: Int): Builder = {
      this.wisdom = wisdom
      this
    }

    def setCharisma(charisma: Int): Builder = {
      this.charisma = charisma
      this
    }
  }

}

class Stat(val builder: Stat.Builder) {
  var strength: Int = builder.strength
  var constitution: Int = builder.constitution
  var dexterity: Int = builder.dexterity
  var intelligence: Int = builder.intelligence
  var wisdom: Int = builder.wisdom
  var charisma: Int = builder.charisma

}
