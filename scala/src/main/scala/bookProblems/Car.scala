package bookProblems

/**
 * Created by Gustavo on 9/17/14.
 */
object Car {
  def apply(manufacturer:String, model:String) = new Car(manufacturer, model)
}

class Car(val manufacturer:String, val model:String, val year:Int, var licensePlate:String) {

//  def manufacturer //how can I make an accessor of the same name? Is that allowed?
  def this(manufacturer:String, model:String) = {
    this(manufacturer, model, -1, "")
  }

}
