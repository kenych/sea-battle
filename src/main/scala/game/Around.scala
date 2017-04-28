package game

import game.Pos._

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 23/11/2013
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
trait Around extends FieldGame {

  def upper = (col: Int, row: Int) => if (row > 0) (true, row - 1, col) else (false, -1, -1)

  def right = (col: Int, row: Int) => if (col < columns - 1) (true, row, col + 1) else (false, -1, -1)

  def upperRight = (col: Int, row: Int) => if (row > 0 && col < columns - 1) (true, row - 1, col + 1) else (false, -1, -1)

  def lowerRight = (col: Int, row: Int) => if (row < rows - 1 && col < columns - 1) (true, row + 1, col + 1) else (false, -1, -1)

  def lower = (col: Int, row: Int) => if (row < rows - 1) (true, row + 1, col) else (false, -1, -1)

  def lowerLeft = (col: Int, row: Int) => if (row < rows - 1 && col > 0) (true, row + 1, col - 1) else (false, -1, -1)

  def left = (col: Int, row: Int) => if (col > 0) (true, row, col - 1) else (false, -1, -1)

  def upperLeft = (col: Int, row: Int) => if (row > 0 && col > 0) (true, row - 1, col - 1) else (false, -1, -1)

  def locationsAround = Array(upper, upperRight, right, lowerRight, lower, lowerLeft, left, upperLeft)

  def isSomeAround(p: Pos): Boolean = {
    import p._

    val found = locationsAround.count(nextNearByLocation => {
      val nearByData = nextNearByLocation(x, y)
      if (nearByData._1) isOccupied(newPos(nearByData._3, nearByData._2)) else false
    })

    found > 0
  }

}
