package controllers

import models.Product
import play.api.mvc.{Results, Action, Controller}

/**
 * Created by Gustavo on 10/2/14.
 */
object Products extends Controller {

  def list = Action { implicit request =>
    val products = Product.findAll
    Ok(views.html.products.list(products))
  }

  def show(ean: Long)  = Action { implicit request =>
    Product.findByEan(ean).map { a =>
      Results.Ok(views.html.products.details(a))
    }.getOrElse(Results.NotFound)
  }
}
