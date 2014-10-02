package models

import play.api.mvc.{Action, Results}



/**
 * Created by Gustavo on 10/2/14.
 */
case class Product(ean: Long, name: String, description: String) {
  override def toString = "%s - %s".format(ean, name)
}

/**
 * Products data access
 */
object Product {

  var products = Set(
    Product(5010255079763L, "Paperclips Large", "Large Plain Pack of 1000"),
    Product(5018206244666L, "Giant Paperclips", "Giant Plain 51mm 100 pack"),
    Product(5018306332812L, "Paperclip Giant Plain", "Giant Plain Pack of 10000"),
    Product(5018306312913L, "No Tear Paper Clip", "No Tear Extra Large Pack of 1000"),
    Product(5018206244611L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 Pack")
  )
  def findAll = products.toList.sortBy(_.ean)

  def findByEan(ean : Long) = products.find(_.ean == ean)



}