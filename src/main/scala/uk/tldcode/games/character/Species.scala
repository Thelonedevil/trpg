package uk.tldcode.games.character

import java._

object Species {
  val registered: util.Map[String, Species] = new util.HashMap[String, Species]

  class Builder(var name: String) {
    def build: Species = {
     new Species(this)
    }
  }

  def register(species: Species): Species = {
    registered.put(species.registeredName, species)
  }


    register(new Species.Builder("Dragonborn").build)
    register(new Species.Builder("Drow").build)
    register(new Species.Builder("Dwarf").build)
    register(new Species.Builder("Elf").build)
    register(new Species.Builder("Gnome").build)
    register(new Species.Builder("Orc").build)
    register(new Species.Builder("Human").build)
    register(new Species.Builder("Demon").build)
    register(new Species.Builder("Halfling").build)

}

class Species private(val builder: Species.Builder) {
  var name: String = builder.name
  var registeredName: String = name.replace(" ", "_").replace("-", "_").toUpperCase
}
