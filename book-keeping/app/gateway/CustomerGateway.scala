package gateway

import javax.inject.{Inject, Singleton}

import config._
import models.{Accountant, Customer}
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CustomerGateway @Inject()(conf: Configuration, ws: WSClient)(implicit ec: ExecutionContext){

  def all: Future[Seq[Customer]] = {
    ws.url(s"${conf.customerHost}/customers").get().map {
      resp => resp.status match {
        case 200 => Json.parse(resp.body).as[Seq[Customer]]
        case s if s >=400 && s < 499 => throw new DownStream4XXException(s"Customer microservice http error in downstream: $s")
        case s if s >=500 && s < 599 => throw new DownStream5XXException(s"Customer microservice http error in downstream: $s")
        case s =>  throw new DownStreamUnknownException(s"Customer microservice http error in downstream: $s")
      }
    } recover {
      case e: Throwable => throw new DownStreamException(s"Customer microservice exception in downstream", e)
    }
  }

}
