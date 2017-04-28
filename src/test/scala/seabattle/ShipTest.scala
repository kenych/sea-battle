package seabattle

import org.junit.Assert._
import org.hamcrest.CoreMatchers._


import org.junit._
import Direction._
import Ship._
import scala.util.Random


/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 17/11/2013
 * Time: 21:11
 * To change this template use File | Settings | File Templates.
 */
class ShipTest {


  @Test
  def constructor() {

    val size = 2
    val ship = new Ship(size)

//    assertEquals(size, ship.size)
//    assertEquals(size, ship.cabins.length)
  }

  @Test
  def testFarthest {

    val ship = new Ship(9)
//    assertTrue(ship.farthestStart + ship.size == SeaBattle.SIZE)
  }


}
