package bookProblems.random

/**
 * Created by Gustavo on 9/18/14.
 */
object Random {
  private var n = 23
  def setSeed(n : Int): Unit = {
    this.n = n
  }

  def nextInt() : Int = {
    n = n * 1664525 + (1013904223 % (0x10 << 32))
    n
  }

  def nextDouble() : Double = {
    Math.abs(nextInt() / Int.MaxValue.asInstanceOf[Double])
  }
}
