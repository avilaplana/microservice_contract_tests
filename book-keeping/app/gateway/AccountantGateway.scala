package gateway

import javax.inject.{Inject, Singleton}

import config._
import models.Accountant
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.ExecutionContext

@Singleton
class AccountantGateway @Inject()(conf: Configuration, ws: WSClient)(implicit ec: ExecutionContext) {

  def findByLicense(license: String) = {
    ws.url(s"${conf.accountHost}/accountant/$license").get().map {
      resp => resp.status match {
        case 200 => Some(Json.parse(resp.body).as[Accountant])
        case 404 => None
        case s if s >= 500 && s < 599 => throw new DownStream5XXException(s"Customer microservice http error in downstream: $s")
        case s if s >= 400 && s < 499 => throw new DownStream4XXException(s"Customer microservice http error in downstream: $s")
        case s => throw new DownStreamUnknownException(s"Customer microservice http error in downstream: $s")
      }
    } recover {
      case e: Throwable => throw new DownStreamException(s"Customer microservice exception in downstream", e)
    }
  }

}
