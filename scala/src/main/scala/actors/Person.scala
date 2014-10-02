package actors

import akka.actor.{ActorLogging, Actor}

/**
 * Created by Gustavo on 9/28/14.
 */
class Person extends Actor with ActorLogging {
  override def receive: Receive = {
    case FullPint(number) =>
      log.info(s"I'll make short work of this $number")
      Thread.sleep(1000)
      log.info(s"Done, here is the empty glass for pint $number")
      sender ! EmptyPint(number)
  }
}