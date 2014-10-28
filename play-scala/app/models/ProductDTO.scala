package models

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{Column, Tag}

class Products(tag : Tag) extends Table[Product](tag, "products") {

  def ean: Column[Long] = column[Long]("ean", O.PrimaryKey)
  def name: Column[String] = column[String]("name")
  def description: Column[String] = column[String]("description")

  def * = (ean, name, description) <> ((Product.apply _).tupled, Product.unapply)
}

object Products {
  val products = TableQuery[Products]
}
