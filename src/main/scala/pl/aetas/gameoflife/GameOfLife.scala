package pl.aetas.gameoflife

import org.slf4j.LoggerFactory

class Board(cells: Cell*) {

  val liveCells: Set[Cell] = cells.toSet

  private val LOGGER = LoggerFactory.getLogger(classOf[Board])

  if (LOGGER.isDebugEnabled) {
    LOGGER.debug(liveCells.map(c => c.toString + " ").toSeq + "\n")
  }

  def countLiveNeighbours(cell: Cell): Int = liveCells.count(_.isNeighbour(cell))
  def isAlive(cell: Cell) = liveCells.contains(cell)
  def next(): Board = {

    val cellsToCheck: Set[Cell] = liveCells.flatMap(cell => {
      cell.getNeighbours :+ cell
    })

    def isEligible(cell: Cell): Boolean = {
      val neighbourNumber: Int = countLiveNeighbours(cell)
      (isAlive(cell) && neighbourNumber >= 2 && neighbourNumber <= 3) || (neighbourNumber == 3)
    }

    new Board(cellsToCheck.filter(isEligible).toSeq:_*)
  }
}

case class Cell(x: Int, y: Int) {
  def isNeighbour(cell: Cell): Boolean = getNeighbours.contains(cell)

  def getNeighbours: Seq[Cell] = {
    for {
      x <- -1 to 1
      y <- -1 to 1
      if x != 0 || y != 0
    } yield {
      new Cell(this.x + x, this.y + y)
    }
  }
}