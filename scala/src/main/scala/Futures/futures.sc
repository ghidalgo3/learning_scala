import scala.concurrent._
import duration._
import concurrent.ExecutionContext.Implicits.global
import scala.util.Random

//val a = Future {
//  Thread.sleep(3000)
//  println("here")
//  1
//}
//val b = a.map(_ + 1)
//
//Await.result(a, Duration.Inf)

def time(f : => Unit): Double = {
  val startTime = System.nanoTime()
  f
  (System.nanoTime() - startTime) / 1000000.0
}

def gen = Future {
  Thread.sleep(3000)
  println("here")
  Random.nextInt(10)
}

//def c:Future[String] = for {
//          a <- gen
//          b <- gen
//          d <- gen
//          f <- gen
//        } yield {
//          val total = a + b + d + f
//          if(total % 2 == 0) s"$total is even" else s"$total is odd"
//        }

def c:Future[String] = {
  val fa = gen
  val fb = gen
  val fc = gen
  val fd = gen
  for {
    a <- fa
    b <- fb
    c <- fc
    d <- fd
  } yield {
    val total = a + b + c + d
    if(total % 2 == 0) s"$total is even" else s"$total is odd"
  }
}



time{
  Await.result(c, Duration.Inf)
}
