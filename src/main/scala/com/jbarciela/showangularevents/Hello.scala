package com.jbarciela.showangularevents

import java.io.File;
import ammonite.ops._

/*
 * TODO:
 * - unique list of event names
 * - association with file name (make it unique with path)
 * - add direction to sources
 *     - $emit sends messages up the scope chain
 *     - $broadcast sends messages down
 * - remove hardcoded values! 
 * - get line numbers where the needles are
 */
object Hello {
  
  val extensions: List[String] = List(".js", ".ts")
  val needles: List[String] = List("$emit(", "$broadcast(", "$on(")
  def main(args: Array[String]): Unit = {
    val thedir = root/'Users/'jbarciela/'work/'ultra/"ultra-ui"
    val listed = ls.rec! thedir |? (_.ext == "ts")
    listed.foreach( (f: ammonite.ops.Path) => {
      val emitLines = read.lines(f).filter(line => line.containsSlice("emit"))
      emitLines.foreach( emitLine => {
        println(f.segments)
        println(f.last)
        println(f.name)
        println(emitLine)
      })
    })
    println(listed.size)
  }
}
