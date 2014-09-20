package unitCalculator

/**
 * Created by Gustavo on 9/19/14.
 */

abstract class FundamentalUnit(val value: Double) {
  def +(other: FundamentalUnit) : FundamentalUnit
  def -(other: FundamentalUnit) : FundamentalUnit
  def name: Dimension
  def canAdd(other:FundamentalUnit) : Unit
  implicit def valueUnpacker(f : FundamentalUnit) : Double = value
}


