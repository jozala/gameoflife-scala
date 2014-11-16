name := "gol-scala"

organization := "pl.aetas"

version := "1.0"

publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

scalaVersion := "2.11.4"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "com.google.guava" % "guava" % "16.0"

javacOptions ++= Seq("-source", "1.8")
