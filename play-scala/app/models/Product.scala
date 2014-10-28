package models

import scala.slick.driver.MySQLDriver.simple._
/**
 * An entry in the product catalogue.
 *
 * @param ean EAN-13 code - a unique product identifier
 * @param name Product name
 * @param description Product description
 */
case class Product(ean: Long, name: String, description: String) {
  override def toString = "%s - %s".format(ean, name)
}

/**
 * Products data access
 */
object Product {

  val table = Products.products

  //I don't know what I'm doing, but basically there will be a Set() that is used for searching
  //When a search happens, don't access the database, just look in the Set.
  //When a modification happens (insert/delete) then update the database and update the set as well.
  var products : Set[Product] = Set()

  var schemaInited = false
  def initSchema : Boolean = {
    if(!schemaInited) {
      //address of database            //name of Driver
      Database.forURL("jdbc:mysql:products", driver = "com.mysql.jdbc.Driver") withSession {
        implicit session =>
          table.ddl.create
          table ++= Seq(
            Product(5010255079763L, "Paperclips Large", "Large Plain Pack of 1000"),
            Product(5018206244666L, "Giant Paperclips", "Giant Plain 51mm 100 pack"),
            Product(5018306332812L, "Paperclip Giant Plain", "Giant Plain Pack of 10000"),
            Product(5018306312913L, "No Tear Paper Clip", "No Tear Extra Large Pack of 1000"),
            Product(5018206244611L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 Pack")
          )
          //this line is equivalent to "select * from products"
          table foreach { case p: Product => products = products + p}
      }
    }
    if(!schemaInited) { schemaInited = true; false } else true
  }

  //Have this helper method for database access
  private def database(f : => Unit) = {
    Database.forURL("jdbc:mysql://127.0.0.1:3306/products", driver = "com.mysql.jdbc.Driver") withSession {
      implicit session => f
    }
  }

  /**
   * Products sorted by EAN code.
   */
  def findAll = products.toList.sortBy(_.ean)

  /**
   * The product with the given EAN code.
   */
  def findByEan(ean: Long) = {
    products.find(_.ean == ean)
  }

  /**
   * Products whose name matches the given query.
   */
  def findByName(query: String) = products.filter(_.name.contains(query))

  /**
   * Deletes a product from the catalog.
   */
  def remove(product: Product) = {
    val oldProducts = products
    Database.forURL("jdbc:mysql:products", driver = "com.mysql.jdbc.Driver") withSession {
      implicit session =>
        table.filter(_.ean === product.ean).delete //da fuq
    }
    products = products - product
    oldProducts.contains(product)
  }

  /**
   * Adds a product to the catalog.
   */
  def add(product: Product) {
    Database.forURL("jdbc:mysql:products", driver = "com.mysql.jdbc.Driver") withSession {
      implicit session =>
        table.insert(product)//wow that was really easy!
    }
    products = products + product
  }
}
