package seabattle

import Direction._
import game.{Around, Pos, FieldGame}


import SeaBattle._
import Pos._


class SeaBattle extends FieldGame(SIZE, SIZE) with Around {

  var temp: Boolean = true
  var hitPos: Option[Pos] = None
  var currShip: Integer = 0;

  def createShips(clearShips: Unit, retries: Integer = 0): Option[List[Ship]] = {
    initCells

    var ships: List[Ship] = Nil

    for (shipSize <- SHIP_SIZES) {

      val ship: Option[Ship] = createShipBySize(shipSize, isSomeAround)

      if (!ship.isEmpty) ships = ship.get :: ships
      else if (retries < MAX_TRIES) {
        println("new try of combination")
        Thread.sleep(2000)

        return createShips(clearShips, retries + 1)
      } else None

      ship.get.cabins.foreach(occupyCell)

    }
    Option(ships)
  }


  def show(sec: Int) {
    println(draw)
    Thread.sleep(2000 * sec)
  }

  def createShipBySize(size: Int, invalidPos: (Pos) => Boolean, retries: Integer = 0): Option[Ship] = {

    currShip = size
    println("\ncreating ship of size :" + size)
    show(1)

    val ship = new Ship(size);

    import ship.{addCabin, direction => shipDirection, nonDirectionBasedStart, directionBasedStart}
    val dbs = directionBasedStart


    val persistentPoint = nonDirectionBasedStart

    for (movingPoint <- dbs until dbs + size) {
      val pos = createPos(shipDirection, movingPoint, persistentPoint)

      println("\nadding cabin at " + pos)

      if (invalidPos(pos)) {

        if (isOccupied(pos)) {
          println("\nups: hit the other cabin, start from beginning!")
          hitPos = Option(pos)
          show(1)
          hitPos = None
        } else {
          println("\nups: hit the border of other cabin, start from beginning!")
          occupyTmpCell(pos)
          show(1)
          unOccupyTmpCell(pos)
        }

        ship.cabins.foreach(unOccupyTmpCell)
        return if (retries < MAX_TRIES) createShipBySize(size, invalidPos, retries + 1) else None
      }
      else addCabin(pos)


      occupyTmpCell(pos)
      show(1)
    }

    Option(ship)
  }


  def createPos(d: Direction, movingPoint: Int, persistentPoint: Int): Pos = {

    if (d == Vertical) new Pos(persistentPoint, movingPoint)
    else new Pos(movingPoint, persistentPoint)

  }

  override def drawCell(column: Int, row: Int) =
    if (!temp) if (isOccupied(newPos(column, row))) "*" else "_"
    else {
      if (hitPos.isDefined && hitPos.get.x == column && hitPos.get.y == row) "X"
      else if (isTempOccupied(newPos(column, row)) && isOccupied(newPos(column, row))) "O"
      else if (isTempOccupied(newPos(column, row))) currShip.toString
      else "_"
    }

}


object SeaBattle {
  val SIZE = 10
  val MAX_TRIES = 20
  var SHIP_SIZES = Array(4, 3, 3, 2, 2, 2, 1, 1, 1, 1)
}