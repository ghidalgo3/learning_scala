package Pi

import akka.actor.Actor.Receive
import akka.actor._

case class WorkUnit(x:Double, start:Int, length:Int)
case class Result(result:Double)

class Euler {
  def run(): Unit = {
    var system = ActorSystem("fastmath")
    val supervisor = system.actorOf(Props[Supervisor], "manager")
    val x = 1
    for(i <- 0 to 5) {
      val actor = system.actorOf(Props[Worker], s"Worker$i")
      actor.tell(WorkUnit(x, i*2, 2), supervisor)
    }
    system.terminate()
  }

  def factorial(n : Int) : Double = {
    var accum = 1
    for(i <- 1 to n)  accum *= i
    accum
  }

  def run2(): Double = {
    val x = 1
    (0 to 10000).par.map {
      i =>
        var accumulator = 0.0
        val start = i*2
        val length = 2
        for(i <- start.to(start+length-1)) {
          accumulator += Math.pow(x, i) / factorial(i)
        }
        accumulator
    }.reduce( _+_ )
  }

  def run3(): Double = {
    val x = 1
    (0 to 10000).map {
      i =>
        var accumulator = 0.0
        val start = i*2
        val length = 2
        for(i <- start.to(start+length-1)) {
          accumulator += Math.pow(x, i) / factorial(i)
        }
        accumulator
    }.reduce( _+_ )
  }

}

class Worker extends Actor{

  def factorial(n : Int) : Double = {
    var accum = 1
    for(i <- 1 to n)  accum *= i
    accum
  }

  override def receive: Receive = {
    case WorkUnit(x, start, length) => {
      var accumulator:Double = 0.0
      for(i <- start.to(start+length-1)) {
        accumulator += Math.pow(x, i) / factorial(i)
      }
      sender ! Result(accumulator)
    }

  }
}

class Supervisor extends Actor with ActorLogging {
  var E : Double = 0.0
  override def receive: Actor.Receive = {
    case Result(result) => {
      E += result
      log.info(s"Current value of E is $E. Last message received from ${sender.path}")
    }
  }
}
