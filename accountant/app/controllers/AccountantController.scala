package controllers

import javax.inject.Inject

import models.{Accountant, AccountantRepository}
import play.api.libs.json.{JsError, Json}
import play.api.mvc.{Action, BodyParsers, Controller}

import scala.concurrent.{ExecutionContext, Future}

class AccountantController @Inject()(repo: AccountantRepository)
                                    (implicit ec: ExecutionContext) extends Controller {


  def findByLicense(license: String) = Action.async {
    repo.findByLicense(license) map {
      case Some(a) => Ok(Json.toJson(a))
      case None => NotFound
    }
  }


  def create() = Action.async(BodyParsers.parse.json) { request =>

    request.body.validate[Accountant].fold(
      errors => {
        Future.successful(BadRequest)
      },
      acc => {
        repo.create(acc).map {
          case _ => Created
        }
      }
    )
  }
}
