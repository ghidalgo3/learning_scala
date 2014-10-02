package actors

import akka.actor.Actor.Receive
import akka.actor._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
 * Created by Gustavo on 9/28/14.
 */

case class Ticket(quantity : Int)
case class FullPint(number : Int)
case class EmptyPint(number : Int)

object HowdyAkka {

  def run : Unit = {
    val system = ActorSystem("HowdyAkka")
    val zed = system.actorOf(Props[BarTender], "zed")
    val alice = system.actorOf(Props[Person],"alice")
    val bob = system.actorOf(Props[Person],"bob")
    val charlie = system.actorOf(Props[Person],"charlie")
    zed.tell(Ticket(2), alice)
    zed.tell(Ticket(3), bob)
    zed.tell(Ticket(1), charlie)
    Await.result(system.whenTerminated, Duration.fromNanos(1000000000000L))
  }


}
