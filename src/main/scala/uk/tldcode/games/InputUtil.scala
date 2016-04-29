package uk.tldcode.games

import java.util.Scanner

object InputUtil {
  val scanner: Scanner = new Scanner(System.in)

  def isInteger(str: String): Boolean = {
    if (str == null) {
      return false
    }
    val length: Int = str.length
    if (length == 0) {
      return false
    }
    var i: Int = 0
    if (str.charAt(0) == '-') {
      if (length == 1) {
        return false
      }
      i = 1
    }

    for ((c:Char, i) <- str.toCharArray.view.zipWithIndex) {
      if (c < '0' || c > '9') {
        return false
      }
    }
    true
  }
}