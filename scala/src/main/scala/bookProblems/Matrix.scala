package bookProblems

/**
 * Created by Gustavo on 9/18/14.
 */
class Matrix(rows: Int, cols: Int) {

  private val matrix = Array.ofDim[Float](rows, cols)

  //submatrix determination for calculating determinants of matrices
  def submatrix(i : Int, j : Int, matrix : Array[Array]) = {
    //returns a new array of size n-1 with the ith index removed
    def removeIndex(index : Int, arr: Array): Array = {
      arr
        .zipWithIndex //what you call if you need an indexed loop
        .filter{ case (_,index) => index != r }
        .map { case (value, _) => value }
    }
    removeIndex(i , matrix.map{ case row => removeIndex(j, row) } )
  }




//  override def toString() : String = {
//    matrix.flatMap(row => row.mkString(",")).flatMap()
//  }
}
