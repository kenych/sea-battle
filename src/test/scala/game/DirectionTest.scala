package game

import org.junit.Test
import org.junit.Assert._
import org.hamcrest.CoreMatchers._
import Direction._

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 17/11/2013
 * Time: 23:38
 * To change this template use File | Settings | File Templates.
 */
class DirectionTest {

  @Test
  def testRandomDirection() {

    assertThat(randomDirection, anyOf(is(Horizontal),is(Vertical)))


  }


}
