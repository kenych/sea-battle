package game

import CellFactory._

abstract class FieldGame(val columns: Int, val rows: Int) {

  var cells = Array.ofDim[Cell](columns, rows)
  var cellsTemp = Array.ofDim[Cell](columns, rows)

  def initCells = {
    cells = Array.ofDim[Cell](columns, rows)
    cellsTemp = Array.ofDim[Cell](columns, rows)

    for (rowIndex <- 0 until rows)
      for (colIndex <- 0 until columns) {
        cells(rowIndex)(colIndex) = Cell(colIndex, rowIndex)
        cellsTemp(rowIndex)(colIndex) = Cell(colIndex, rowIndex)
      }
  }

  def draw = {
    val lines: StringBuffer = new StringBuffer
    for (rowIndex <- 0 until rows) lines.
      append(drawLine(rowIndex)).
      append(if (rowIndex != rows - 1) "\n" else "")

    lines.toString
  }

  def drawLine(rowIndex: Integer): String = {
    val line: StringBuffer = new StringBuffer
    for (columnIndex <- 0 until columns) line.
      append(drawCell(rowIndex, columnIndex))

    line.toString
  }


  def drawCell(column: Int, row: Int): String


  def occupyCell(p: Pos) = {
    cells(p.x)(p.y).occupied = true

  }

  def occupyTmpCell(p: Pos) = {
    cellsTemp(p.x)(p.y).occupied = true
  }

  def unOccupyTmpCell(p: Pos) = {
    cellsTemp(p.x)(p.y).occupied = false
  }

  def clearTmpCells {
    cellsTemp = Array.ofDim[Cell](columns, rows)
  }

  def isOccupied(p: Pos) = cells(p.x)(p.y).occupied

  def isTempOccupied(p: Pos) = cellsTemp(p.x)(p.y).occupied


}