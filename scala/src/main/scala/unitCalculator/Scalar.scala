package unitCalculator

/**
 * Created by Gustavo on 9/19/14.
 */

object Scalar {
  //but we also added an apply(Double, SIUnit)
  def apply(magnitude: Double, unit: SIUnit) = {
    new Scalar(magnitude, Dimension(Map(unit->1)))
  }
}

//case class means we get an apply(Double, Dimension)
case class Scalar(magnitude: Double, dimen : Dimension){

  def canAdd(other:Scalar) : Boolean = dimen == other.dimen

  def *(other: Scalar) : Scalar = {
    Scalar(this.magnitude * other.magnitude, dimen * other.dimen)
  }

  def +(other: Scalar) : Scalar = {
    if(canAdd(other)) Scalar(this.magnitude + other.magnitude, dimen) else throw new UnsupportedOperationException
  }

  def isFundamentalUnit : Boolean = {
    dimen.units.size == 1 && dimen.units.head._2 == 1
  }
  def /(other: Scalar) : Scalar = Scalar(this.magnitude / other.magnitude, dimen / other.dimen)

  def -(other: Scalar) : Scalar = {
    if(canAdd(other)) Scalar(this.magnitude - other.magnitude, dimen) else throw new UnsupportedOperationException
  }

  def as(other: DerivedUnit) : String = {
    magnitude.toString + other.toString + (dimen/other.dimen).toString
  }

  override def toString: String = {
    magnitude.toString + dimen.toString
  }

}


