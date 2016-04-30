package uk.tldcode.games

import java.io.InputStream

import uk.tldcode.games.character.nonplayable.Enemy
import uk.tldcode.games.character.playable.Player
import uk.tldcode.games.character.{Character, Stat}
import uk.tldcode.games.engine.{CombatTurn, RestTurn, TravelTurn, Turn}

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.parsing.json._

object App {

  def main(args: Array[String]) {
    val player = new Player("TLD", new Stat(strength = 8, constitution = 14, dexterity = 17, intelligence = 10, wisdom = 14, charisma = 12))
    val campaign = parseDefaultCampaign()
    val players: Seq[Player] = new java.util.HashSet[Player](java.util.Arrays.asList(player)).asScala.toList
    campaign.foreach(t=>{
      t.setPlayers(players)
    })

  }

  def parseDefaultCampaign(): List[Turn] = {
    val turns = new ListBuffer[Turn]
    val stream: InputStream = getClass.getResourceAsStream("/campaigns/default.json")
    val lines = Source.fromInputStream(stream).mkString
    val json = JSON.parseFull(lines)
    json match {
      case Some(map: Map[String, Any]) =>
        val list = map.apply("turns")
        list.asInstanceOf[List[Map[String, Any]]].foreach(turn => {
          turns += parseTurn(turn)
        })
      case None => println("Parsing failed")
      case other => println("Unknown data structure: " + other)
    }
    turns.toList
  }

  def parseTurn(raw: Map[String, Any]): Turn = {
    var turn1: Turn = new RestTurn(new ListBuffer[Character])
    raw.foreach { case (key, value) =>
      key match {
        case "combat" =>
          if (value.asInstanceOf[Boolean])
            turn1 = new CombatTurn(new ListBuffer[Character])
        case "travel" =>
          if (value.asInstanceOf[Boolean])
            turn1 = new TravelTurn(new ListBuffer[Character])
        case "enemies" =>
          var enemies = new ListBuffer[Enemy]()
          value.asInstanceOf[List[Map[String, Any]]].foreach(enemy => {
            enemies += parseEnemy(enemy)
          })
      }
    }
    turn1
  }


  def parseEnemy(raw: Map[String, Any]): Enemy = {
    var name = ""
    var stats = new Stat(0, 0, 0, 0, 0, 0)
    raw.foreach { case (ekey, evalue) =>
      ekey match {
        case "name" =>
          name = evalue.toString
        case "statistics" =>
          stats = parseStats(evalue.asInstanceOf[Map[String, Any]])
      }


    }
    new Enemy(name, stats)
  }

  def parseStats(raw: Map[String, Any]): Stat = {
    var strength = 0
    var dexterity = 0
    var charisma = 0
    var constitution = 0
    var wisdom = 0
    var intelligence = 0
    raw.foreach { case (skey, svalue) =>
      skey match {
        case "strength" =>
          strength = svalue.asInstanceOf[Double].toInt
        case "dexterity" =>
          dexterity = svalue.asInstanceOf[Double].toInt
        case "charisma" =>
          charisma = svalue.asInstanceOf[Double].toInt
        case "constitution" =>
          constitution = svalue.asInstanceOf[Double].toInt
        case "wisdom" =>
          wisdom = svalue.asInstanceOf[Double].toInt
        case "intelligence" =>
          intelligence = svalue.asInstanceOf[Double].toInt
      }
    }
    new Stat(strength = strength, dexterity = dexterity, charisma = charisma, constitution = constitution, intelligence = intelligence, wisdom = wisdom)
  }

}

