package bookProblems

import java.util.Date

object Person {
  def giveId = 10;
}

/**
 * Created by Gustavo on 9/17/14.
 */
class Person(val name:String) {
//  var age = 0 //implicitly public
  //there are now two implicit methods age() : Int and age_=(Int), getter and setter respectively

  private val id = Person.giveId

  def this(name:String, age:Int) {
    this(name)
    this.age = age
  }
  private var _age = 0 //Object-C making a comeback
  val timeStamp = new java.util.Date //because this is a val, no setter is generated

  def age = _age
  def age_=(newAge : Int) { if (!(newAge < _age)) _age = newAge}






}
