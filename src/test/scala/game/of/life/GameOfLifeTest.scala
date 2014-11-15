package game.of.life

import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}

import scala.collection.mutable

class GameOfLifeTest extends FlatSpec with Matchers with MockitoSugar {

  "Cell specified on the board" should "be alive" in {
    val board = new Board(Cell(1,1))
    board.isAlive(1,1) shouldBe true
  }
  "Cell not specified on the board" should "be dead" in {
    val board=new Board(Cell(0,1))
    board.isAlive(1,1) shouldBe false
  }

  "Board" should "calculate live neighbours vertically" in {
    val board=new Board(Cell(1,1), Cell(1,2))
    board.countNeighbours(1,1) should be (1)
  }

  "Board" should "calculate live neighbours horizontally" in {
    val board=new Board(Cell(1,1), Cell(2,1),Cell(0,1))
    board.countNeighbours(1,1) should be (2)
  }

}

class Board(cells: Cell*) {
  def countNeighbours(x: Int, y: Int): Int = {
    var sum=0
    if (isAlive(x-1,y)) sum += 1
    if (isAlive(x+1,y)) sum += 1
    if (isAlive(x,y+1)) sum += 1
    if (isAlive(x,y-1)) sum += 1

    return sum
  }

  def isAlive(x: Int, y: Int)= { if (cells.contains(Cell(x,y))) true else false}


}

case class Cell(x: Int, y: Int)
