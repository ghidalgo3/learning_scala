object Test {
  def swap(input: Array[Int]) : Array[Int] = {
    var arr = Array(input:_*)
    var i = 0;
    while(i < arr.length -1) {
      var buff = arr(i)
      arr(i) = arr(i+1)
      arr(i+1) = buff
      i = i + 2
    }
    return arr.toArray
  }

  def fswap(input: Array[Int]) : Array[Int] = {
    input
      .sliding(2,2)
      .map {
        array => array match {
          case Array(first,second) => Array(second,first)
          case Array(first) => Array(first)
        }
      }
      .flatten
      .toArray
  }

  def reverseSort(arr: Array[Int]) = {
//    arr.sorted.reverse
    arr.sortBy(v => -v)
  }

  def myDistinct(arr:Array[Int]) = {
    arr
      .sorted
      .foldLeft( (Int.MaxValue, List[Int]()) )
       {
        case ((prev,list), v) =>
          if(v != prev) {
            (v, v::list)
          } else {
            (v, list)
          }
        }
      ._2
      .toArray
  }




  def fswap2(input: Array[Int]) : Array[Int] = {
    input
      .sliding(2,2)
      .flatMap {
      case Array(first,second) => Array(second,first)
      case Array(first) => Array(first)
      }
      .toArray
  }

  def average[T](input : Array[T])(implicit ev: Integral[T]) = {
    ev.quot(input.sum, ev.fromInt(input.length));
  }

  def average2[T](input : Array[T])(implicit ev: Integral[T]) = {
    import ev._
    input.sum / fromInt(input.length)
  }




}
