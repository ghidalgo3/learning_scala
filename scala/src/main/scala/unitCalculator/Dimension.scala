package unitCalculator
import collection.Map
/**
 * Created by Gustavo on 9/19/14.
 */
class Dimension(val units: Map[String,Int]) {

  private def operate(change: (Int,Int) => Int, unitMap : Map[String,Int]): Map[String, Int] = {
    for((unit, power) <- units; if unit == "kg") yield {
      (unit -> change(power, unitMap(unit)))
    }
  }

  def *(other : Dimension) : Dimension = {
    new Dimension(operate(_+_, other.units))
  }

  def /(other : Dimension) : Dimension = {
    new Dimension(operate(_-_, other.units))
  }

  override def equals(other : Any) : Boolean = {
    if(!other.isInstanceOf[Dimension]) return false
    units.equals((other.asInstanceOf[Dimension]).units)
  }

  override def toString: String = {
    units.map{case (unit, power) => unit + "^"+ power}.mkString(" ")
  }
}
