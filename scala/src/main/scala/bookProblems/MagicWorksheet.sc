def executeUntilTimeout(timeout : Long)(f : => Unit) = {
  val execThread = createThread(f)
  execThread.start()
  execThread.join(timeout)
}

def time(f : => Unit): Double = {
  val startTime = System.nanoTime()
  f
  (System.nanoTime() - startTime) / 1000000.0
}

def createThread(f : => Unit): Thread = {
  new Thread(new Runnable {
    override def run(): Unit = f
  })
}

executeUntilTimeout(timeout = 1000) {
  (1 to 10000000).count(_ % 2 == 0)
  System.out.println("done")
}

import Pi._

val a = new Euler()

//time(a.run)
time(a.run2)
time(a.run3)

