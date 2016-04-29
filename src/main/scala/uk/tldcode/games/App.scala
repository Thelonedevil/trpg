package uk.tldcode.games

import java.io.InputStream

import uk.tldcode.games.character.nonplayable.Enemy
import uk.tldcode.games.character.playable.Player
import uk.tldcode.games.character.{Character, Stat}
import uk.tldcode.games.engine.{CombatTurn, Turn}

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.parsing.json._

object App {

  def main(args: Array[String]) {
    val player: Player = new Player("TLD", new Stat.Builder().setStrength(8).setConstitution(14).setDexterity(17).setIntelligence(10).setWisdom(14).setCharisma(12).build)
    val enemy: Enemy = new Enemy("Goblin", new Stat.Builder().setStrength(8).setConstitution(14).setDexterity(17).setIntelligence(10).setWisdom(14).setCharisma(12).build)
    val campaign: ListBuffer[Turn] = new ListBuffer[Turn]
    val stream: InputStream = getClass.getResourceAsStream("/campaigns/default.json")
    val lines = Source.fromInputStream(stream).mkString
    val json = JSON.parseFull(lines)
    lines.foreach(println)
    json match {
      case Some(map: Map[String, Any]) =>
        println(map)
        val list = map.apply("turns")
        list.asInstanceOf[List[Map[String, Any]]].foreach(turn => {
          var turn1 = new CombatTurn(new ListBuffer[Character])
          turn.foreach { case (key, value) => {
            if (key.equalsIgnoreCase("combat") && value.asInstanceOf[Boolean]) {
              turn1 = new CombatTurn(new ListBuffer[Character])
            } else if (key.equalsIgnoreCase("enemies")) {
              value.asInstanceOf[List[Map[String, Any]]].foreach(enemy => {
                enemy.foreach { case (ekey, evalue) => {
                  
                }
                }
              })
            }
          }
          }

        })
        println(list)
      case None => println("Parsing failed")
      case other => println("Unknown data structure: " + other)
    }

    val characters: Seq[Character] = new java.util.HashSet[Character](java.util.Arrays.asList(player, enemy)).asScala.toList
    val turn1: Turn = new CombatTurn(characters)
    println("Turn 1")
    turn1.start()
  }

}
