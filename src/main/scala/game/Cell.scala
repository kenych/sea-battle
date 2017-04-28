package game

class Cell(p: Pos) {

  var occupied: Boolean = false

  override def toString = "Pos: " + p + " occupied: " + occupied + " /// "

}

object CellFactory {

  def Cell(p: Pos) = new Cell(p)

  def Cell(x: Int, y: Int) = new Cell(new Pos(x, y))

}

