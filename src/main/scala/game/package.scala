import scala.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 17/11/2013
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */
package object Direction extends Enumeration{
  
  

  type Direction = Value
  val Horizontal = Value("Horizontal")
  val Vertical = Value("Vertical")


  def randomDirection = Direction.apply(Random.nextInt(2))





}
