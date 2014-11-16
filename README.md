Conway's Game of Life
=====================

Conway's Game of Life written in Scala.
This project has been started on Global Day of Coderetreat on 15th of November 2014.

It uses Java-Swing GUI implemented by Brad which is avaliable here:
https://github.com/bjacques/code-examples/tree/master/gui-app


Requirements
------------

- JDK 8
- Scala (version >= 2.11)
- SBT (version >= 0.13.x)

Compile
-------

`sbt compile`


Prepare JAR and run
-------------------

`sbt assembly`

`java -jar target/scala-2.11/gol-scala.jar`
