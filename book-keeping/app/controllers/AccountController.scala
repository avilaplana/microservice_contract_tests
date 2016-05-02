package controllers

import javax.inject.Inject

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import service.AccountService

import scala.concurrent.ExecutionContext

class AccountController @Inject()(accountService: AccountService)
                                 (implicit ec: ExecutionContext) extends Controller {


  def accountantDetails(license: String) = Action.async {
    accountService.details(license) map {
      case Some(a) => Ok(Json.toJson(a))
      case None => NotFound
    } recover {
      case _ => ServiceUnavailable
    }
  }
}
