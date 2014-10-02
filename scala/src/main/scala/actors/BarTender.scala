package actors

import akka.actor.{ActorLogging, Actor}

/**
 * Created by Gustavo on 9/28/14.
 */
class BarTender extends Actor with ActorLogging {
  var total  = 0
  override def receive: Actor.Receive = {

    case Ticket(number) =>
      total += number
      log.info(s"I'll get $number for [${sender.path}]")
      for(numb <- 1 to number) {
        log.info(s"pint $numb is coming right up for [${sender.path}]")
        Thread.sleep(1000)
        log.info(s"Pint $numb is ready, here you go [${sender.path}}]")
        sender ! FullPint(numb)
      }

    case EmptyPint(number) =>
      total match {
        case 1 =>
          log.info("Ya'll drank those pints quick, time to close up shop")
          context.system.terminate()
        case n =>
          total -= 1
          log.info(s"You drank pint $number quick but there are still $total pints left")
      }

  }
}
