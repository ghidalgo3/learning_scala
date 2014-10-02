//case class Box[A](thing:A) {
//  def map[B](f:A=>B):Box[B] = {
//    Box(f(thing))
//  }
//
//  def flatMap[B](f : A => Box[B]) : Box[B] = {
//    f(thing)
//  }
//}

case class Box[A](thing:A) {

  def map[B](f:A=>B):Box[B] = {
    if(isEmpty) {
      Box(null.asInstanceOf[B])
    } else {
      Box(f(thing))
    }
  }

  def flatMap[B](f : A => Box[B]) : Box[B] = {
    if(isEmpty) {
      Box(null.asInstanceOf[B])
    } else {
      f(thing)
    }
  }

  def isEmpty : Boolean = {
    thing == null
  }


}

val b1 = Box(1)
val b2 = Box("String")
val b3 = Box(3.0)
val s:String = null
val b4 = Box(s)
//myBox.map(_+1)
//myBox.flatMap(a => Box(a+1))
for {
  v4 <- b4
  v1 <- b1
  v2 <- b2
  v3 <- b3
} yield {
  (v1,v2,v3,v4)
}


val a = List(Some(1),Some(2),Some(3), None)
a.map {
  elem => elem match {
    case Some(n) => n
    case None =>  0
  }
}.sum

a.flatMap{v => v}.sum`

a.flatten.sum