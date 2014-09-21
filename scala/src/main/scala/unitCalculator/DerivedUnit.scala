package unitCalculator

/**
 * Created by Gustavo on 9/21/14.
 */
sealed trait DerivedUnit {
  def dimen : Dimension
}

object DerivedUnit {
  case object N extends DerivedUnit {
    val dimen = Dimension(Map(SIUnit.kg -> 1, SIUnit.m -> 1, SIUnit.s -> -2))
  }

  case object C extends DerivedUnit {
    val dimen = Dimension(Map(SIUnit.A -> 1, SIUnit.s -> 1))
  }

  case object J extends DerivedUnit {
    val dimen = Dimension(Map(SIUnit.kg -> 1, SIUnit.m -> 2, SIUnit.s -> -2))
  }

  case object W extends DerivedUnit {
    val dimen = Dimension(Map(SIUnit.kg -> 1, SIUnit.m -> 2, SIUnit.s -> -3))
  }
}
