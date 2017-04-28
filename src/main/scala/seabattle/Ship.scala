package seabattle


import Direction._
import game._
import scala.util.Random

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 03/11/2013
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */


class Ship (val size: Int, val direction : Direction = randomDirection) {

  require(size < SeaBattle.SIZE)


  var cabins : List[Pos]   = Nil

  def farthestStart() = {
      SeaBattle.SIZE - size
  }

  def directionBasedStart = {
    Random.nextInt( farthestStart()+1)
  }

  def nonDirectionBasedStart = {
    Random.nextInt( SeaBattle.SIZE)
  }
  
  def addCabin(p: Pos) {cabins = p::cabins}

  override def toString = {
    "size: " + size + ", direction: "+direction+ ", cabins: "+ cabins
  }

}

object Ship  {

  val min = 0


}
