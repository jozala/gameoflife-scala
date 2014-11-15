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

}

class Board(cells: Cell*) {
  def isAlive(x: Int, y: Int) = true

}

case class Cell(x: Int, y: Int)
