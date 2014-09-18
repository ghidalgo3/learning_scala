package bookProblems

import java.io.File
import java.util.Scanner

import scala.collection.mutable

/**
 * Created by Gustavo on 9/17/14.
 * Doing the book problems on Maps
 */
object Maps {
  def one(): Unit = {
    val prices:Map[String, Double] = Map("PSP" -> 200.0, "Samsung 4K Monitor" -> 600.0, "iPhone 6" -> 200.0)
//    val expensivePrices = prices.map((_,price) => (_,price*1.2)) //this doesn't work
//    val expensivePrices = prices.map { case (_,price) => (_,price*1.2) } //missing parameter type why?
    val expensivePrices = prices.map { case (name,price) => (name,price*1.2) } //this one works.... why do I need the name?
    println(prices)
    println(expensivePrices)
  }

  //read a file and build a concordance list of the tokens in the file
  //there's gotta be a nicer way to do this
  def two(fileName:String): Unit = {
    val scanner = new Scanner(new File(fileName))
    val concordanceList = new mutable.HashMap[String, Int]()
    while(scanner hasNext) {
      scanner.nextLine()
        .split(" ")
        .foreach {
          word  => if(concordanceList contains word) {
            concordanceList.update(word, concordanceList(word) + 1)
          } else {
            concordanceList += (word -> 1)
          }
        }
    }
    println(concordanceList)
  }

  //this one was tricky!
  def seven(): Unit = {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val map:mutable.Map[String,String] = System.getProperties
    //Why doesn't this loop yield the max value? doesn't compile at all
//    var x = 0
//    val maxLength:Int = for (key <- map.keySet ) {
//      if (key.length > x) x = key.length else x
//    }
    val maxLength = map.keySet.maxBy(_.length).length //hehe
//    for((key,value) <- map) {
//      println(key.padTo(maxLength, " ").mkString + "|" + value)
//    }
    //this also works.
    //why can't the compiler infer the types of this [String,String] map?
    //why do I need the pattern matching?
    map.foreach{
      case (key:String,value:String) => println(key.padTo(maxLength, " ").mkString + "|" + value)
    }
  }

  //omg is this python
  def minmax(values: Array[Int]) : (Int, Int) = (values.max, values.maxBy(x => -x))

  //
  def lteqgt(values: Array[Int], v:Int): (Int,Int,Int) = {
    //this solution is terrible, always iterates through the array 3 times. can this be done better?
    (values.count(x => x < v), values.count(x => x == v), values.count(x => x > v))
//    var lt = 0
//    var eq = 0
//    var gt = 0
//    for(x <- values) {
//      if(x < v) lt += 1
//      else if(x == v) eq += 1
//      else gt += 1
//    }
//    (lt,eq,gt)
    //uglier but it iterates through the array once.
  }
}
