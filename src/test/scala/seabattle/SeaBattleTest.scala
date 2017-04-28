package seabattle

import org.junit.{Before, Test}
import org.junit.Assert._
import game.Pos
import SeaBattle._

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 17/11/2013
 * Time: 21:54
 * To change this template use File | Settings | File Templates.
 */
class SeaBattleTest {

  @Test
  def testCreateShips {

    println("testShipsDraw")
    val seaBattle = new SeaBattle()
    import seaBattle._

    val optionalShips = createShips(initCells)

    if (!optionalShips.isEmpty){
      val ships = optionalShips.get
      assertEquals(SHIP_SIZES.length, ships.size)
      println(ships(0))
    }

    println(draw)


  }

  val mockInvalidPos = (_: Pos) => {
    false
  }

  @Test
  def testCreateShipBySize {
    println("\n\ntestCreateShipBySize")


    val seaBattle = new SeaBattle()
    import seaBattle._

    val size = 3

    val optionalShip = createShipBySize(size,mockInvalidPos)

    if (!optionalShip.isEmpty){
      assertEquals(size, optionalShip.get.cabins.size)
      println(optionalShip.get)
    }

  }


}
