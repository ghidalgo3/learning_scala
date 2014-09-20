import bookProblems._

val a = Array.ofDim[Int](3,3)
def removeIndex(r : Int, array : Array[Any]): Array[Any] = {
  array
    .zipWithIndex //what you call if you need an indexed loop
    .filter{ case (_,index) => index != r }
    .map { case (value, _) => value }
}

val b:Array[Any] = Array[Any](1,2,3,4,5)
removeRow(2, b).mkString(" ")