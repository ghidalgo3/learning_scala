package unitCalculator

/**
 * Created by Gustavo on 9/19/14.
 */
object Mass {
  implicit def doubleToMass(number : Double) : Mass = new Mass(number)
  implicit def intToMass(number : Int) : Mass = new Mass(number)
}

//the main constructor should have ALL vals, vars in the class
class Mass(value: Double, unitName: String) extends FundamentalUnit(value) {

  def dimen : Dimension = new Dimension(Map("kg"->1))

  //auxiliary constructors have less parameters
  def this(value: Double) {
    this(value, "kg")
  }

  override def toString() : String = value.toString + unitName

  def canAdd(other:FundamentalUnit) : Unit = {
    if(!other.isInstanceOf[Mass]) throw new UnsupportedOperationException
  }

  def *(other: DerivedUnit) : DerivedUnit = new DerivedUnit(this.value * other.value, dimen * other.units)

  def *(other: FundamentalUnit) : DerivedUnit = new DerivedUnit(this.value * other.value, dimen * other.name)

  def +(other: FundamentalUnit) : Mass = {
    canAdd(other)
    new Mass(this.value + other.value)
  }

  def /(other: FundamentalUnit) : DerivedUnit = new DerivedUnit(this.value / other.value, dimen/other.name)

  def /(other: DerivedUnit) : DerivedUnit = new DerivedUnit(this.value / other.value, dimen / other.units)

  def -(other: FundamentalUnit) : Mass = {
    canAdd(other)
    new Mass(this.value - other.value)
  }

  override def name: Dimension = new Dimension(Map("kg"->1))

  def kg: Mass = this
  def kgs: Mass = this

  def lb: Mass = new Mass(this.value / 2.204) //pounds / kilogram
  def lbs = lb


}
