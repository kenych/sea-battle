package game

/**
 * Created with IntelliJ IDEA.
 * User: kayanazimov
 * Date: 17/11/2013
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 */
class Pos (val x: Int, val  y: Int) {

  override def toString = "x:" +y + "/y:"+x //wtf, why ???

}

object Pos {

 def  newPos(x: Int, y: Int) = new Pos(x, y)

}

