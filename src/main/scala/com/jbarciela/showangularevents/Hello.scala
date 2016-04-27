package com.jbarciela.showangularevents

import java.io.File;
import ammonite.ops._

object Hello {
  
  val extensions: List[String] = List(".js", ".ts")
//  val needles: List[String] = List("$emit(", "$broadcast(", "$on(")
  def main(args: Array[String]): Unit = {
    val thedir = root/'Users/'jbarciela/'work/'ultra/"ultra-ui"
    val listed = ls.rec! thedir |? (_.ext == "ts")
    listed.foreach( (f: ammonite.ops.Path) => {
      val emitLines = read.lines(f).filter(line => line.containsSlice("emit"))
      println(emitLines)
    })
    println(listed.size)
  }
}
