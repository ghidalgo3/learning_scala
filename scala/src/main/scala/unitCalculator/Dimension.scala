package unitCalculator
import collection.Map
/**
 * Created by Gustavo on 9/19/14.
 */

case class Dimension(units: Map[SIUnit, Int]) {

  private def operate(change: (Int,Int) => Int, unitMap : Map[SIUnit,Int]): Map[SIUnit, Int] = {
//    for((unit, power) <- units) yield {
//      unit -> change(power, unitMap.getOrElse(unit, 0))
//    }
    units ++ unitMap.map{ case (k,v) => k -> (v + units.getOrElse(k,0)) }
  }

  def *(other : Dimension) : Dimension = {
    Dimension(operate(_+_, other.units))
  }

  def /(other : Dimension) : Dimension = {
    Dimension(operate(_-_, other.units))
  }

  override def toString: String = {
    units
      .collect{ case (unit, power) if power != 0 =>
        unit + (if(power != 1) { "^" + power } else "")
    }.mkString(" ")
  }
}
