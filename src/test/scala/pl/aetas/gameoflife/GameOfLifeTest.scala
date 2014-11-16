package pl.aetas.gameoflife

import org.scalatest.{Matchers, FlatSpec}

class GameOfLifeTest extends FlatSpec with Matchers {

  "Cell specified on the board" should "be seen alive" in {
    val board = new Board(Cell(1, 1))
    board.isAlive(Cell(1,1)) shouldBe true
  }
  "Cell not specified on the board" should "be seen dead" in {
    val board = new Board(Cell(0, 1))
    board.isAlive(Cell(1,1)) shouldBe false
  }

  "Cell" should "count live neighbours vertically" in {
    val board = new Board(Cell(3, 5), Cell(3, 7))
    board.countLiveNeighbours(Cell(3, 6)) should be(2)
  }

  it should "count live neighbours horizontally" in {
    val board = new Board(Cell(3, 3), Cell(4, 3), Cell(2, 3))
    board.countLiveNeighbours(Cell(3, 3)) should be(2)
  }

  "Board" should "calculate live neighbours diagonally" in {
    val board = new Board(Cell(5, 5), Cell(7, 7), Cell(5, 7), Cell(7, 5))
    board.countLiveNeighbours(Cell(6, 6)) should be(4)
  }

  "Live cell" should "stay alive when it has 2 neighbours" in {
    val board = new Board(Cell(3, 3), Cell(4, 4), Cell(4, 3))
    val newBoard = board.next()
    newBoard.isAlive(Cell(4,4)) shouldBe true
  }

  it should "stay alive when it has 3 neighbours" in {
    val board = new Board(Cell(2, 4), Cell(3, 5), Cell(3, 4), Cell(2, 5))
    val newBoard = board.next()
    newBoard.isAlive(Cell(3,5)) shouldBe true
  }

  it should "die when it has more than 3 neighbours" in {
    val board = new Board(Cell(3, 3), Cell(4, 4), Cell(4, 3), Cell(3, 4), Cell(5, 4))
    val newBoard = board.next()
    newBoard.isAlive(Cell(4,4)) shouldBe false
  }

  it should "die when it has less than 2 neighbours" in {
    val board = new Board(Cell(2, 8), Cell(2, 7))
    val newBoard = board.next()
    newBoard.isAlive(Cell(2, 8)) shouldBe false
  }

  "Dead cell" should "become alive when it has exactly 3 neighbours" in {
    val board = new Board(Cell(2, 3), Cell(1, 3), Cell(3, 5 ))
    val newBoard = board.next()
    newBoard.isAlive(Cell(2, 4)) shouldBe true
  }

  it should "stay dead when has 2 neighbours" in {
    val board = new Board(Cell(2, 3), Cell(1, 3))
    val newBoard = board.next()
    newBoard.isAlive(Cell(2, 4)) shouldBe false
  }

  "Cell" should "give all neighbours" in {
    Cell(5, 5).getNeighbours should contain allOf(Cell(4, 4), Cell(5, 4), Cell(6, 4),
      Cell(4, 5), Cell(6, 5),
      Cell(4, 6), Cell(5, 6), Cell(6, 6))
    Cell(5, 5).getNeighbours shouldNot contain(Cell(5, 5))
  }

  "Block of four" should "not change in next generations" in {
    val board = new Board(Cell(10,20), Cell(11, 20), Cell(10,21), Cell(11,21))
    val newBoard = board.next()
    newBoard.liveCells.size should be (4)
  }
}
