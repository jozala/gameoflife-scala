package game.of.life

import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, FlatSpec}

import scala.collection.mutable

class GameOfLifeTest extends FlatSpec with Matchers with MockitoSugar {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new mutable.Stack[Int]

    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

}
