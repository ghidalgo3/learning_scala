package unitCalculator

/**
 * Created by Gustavo on 9/19/14.
 */
class DerivedUnit(val value: Double,val units: Dimension) {

  def *(other: DerivedUnit) : DerivedUnit = {
    new DerivedUnit(this.value * other.value, this.units * other.units)
  }

  def +(other: DerivedUnit) : DerivedUnit = {
    if(!other.units.equals(this.units)) throw new UnsupportedOperationException
    new DerivedUnit(this.value + other.value, this.units)
  }

  def /(other: DerivedUnit) : DerivedUnit = {
    new DerivedUnit(this.value / other.value, this.units / other.units)
  }

  def /(other: FundamentalUnit) : DerivedUnit = {
    new DerivedUnit(this.value / other.value, this.units / other.name)
  }

  def -(other: DerivedUnit) : DerivedUnit = {
    if(!other.units.equals(this.units)) throw new UnsupportedOperationException
    new DerivedUnit(this.value + other.value, this.units)
  }

  override def toString() : String = value + units.toString
}
