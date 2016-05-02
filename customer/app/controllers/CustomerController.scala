package controllers

import javax.inject.Inject

import models.{Customer, CustomerRepository}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import play.api.mvc.Result
import scala.concurrent.{ExecutionContext, Future}

class CustomerController @Inject()(repo: CustomerRepository)
                                  (implicit ec: ExecutionContext) extends Controller {


  def find(passport: Option[String], name: Option[String]) = Action.async {

    val buildResponse: Future[Option[Customer]] => Future[Result] = c => c map {
      case Some(c) => Ok(Json.toJson(c))
      case None => NotFound
    } recover {
      case _ => ServiceUnavailable
    }

    (passport, name) match {
      case (Some(p), Some(n)) => buildResponse(repo.find(n, p))
      case (Some(p), None) => buildResponse(repo.findByPassport(p))
      case (None, Some(n)) => buildResponse(repo.findByName(n))
      case _ => Future.successful(BadRequest)
    }
  }


  def findAll = Action.async {
    repo.findAll map {
      cs => Ok(Json.toJson(cs))
    } recover {
      case _ => ServiceUnavailable
    }
  }
}
