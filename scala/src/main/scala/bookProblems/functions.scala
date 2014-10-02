package bookProblems

/**
 * Created by Gustavo on 9/25/14.
 */
class functions {
  def max(array : Array[Int]) : Int = {
    array.reduceLeft {(a,b) => if(a > b) a else b}
  }

  def largest(fun : (Int) => Int, inputs : Seq[Int]) : Int = {
    max (inputs.map { fun } toArray)
  }

  def largestAt(fun : (Int) => Int, inputs : Seq[Int]) : Int = {
    inputs indexOf largest(fun, inputs)
  }

  def unless(control : => Boolean)(code : => Unit): Unit = { //omg currying is so cool
    if(!control) code
  }

  def charSet(str : String) : Map[Char,Set[Int]] = {
    str
      .zipWithIndex
      .foldLeft(Map[Char, Set[Int]](str(0)->Set(0))) {
        case (map,(char, index)) =>
          if(map.contains(char)) map + (char -> (map(char) ++ Set(index))) else map + (char -> Set(index))
    }
  }
}
