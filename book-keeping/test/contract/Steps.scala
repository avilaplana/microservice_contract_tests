package contract

import cucumber.api.scala.{EN, ScalaDsl}
import models.{Accountant, Customer}
import org.scalatest.Matchers
import play.api.libs.json.Json

import scala.collection._
import scala.util.{Failure, Success, Try}
import scalaj.http.{Http => HttpClient}

class Steps extends ScalaDsl with EN with Matchers {

  var world: mutable.Map[String, String] = mutable.Map.empty[String, String]

  Given("""^The '(.*)' microservice is up and running$"""){ (service: String) =>
    val (status, body) = service match {
      case "Customer" =>
        GET("http://localhost:9002/ping")

      case "Accountant" =>
        GET("http://localhost:9001/ping")

      case _ => throw new IllegalArgumentException("Service not defined")
    }

    status shouldBe statusCode("OK")

    world = world += ("service" -> service)
  }


  When("""^I request 'GET' to the resource '(.*)'$"""){ (resource: String) =>
    val (status, body) = world("service") match {
      case "Customer" =>
        GET(s"http://localhost:9002$resource")

      case "Accountant" =>
        GET(s"http://localhost:9001$resource")

      case _ => throw new IllegalArgumentException("Service not defined")
    }

    world = world += ("status" -> status)
    world = world += ("body" -> body)

  }
  Then("""^The http response is '(.*)'$"""){ (status: String) =>
    statusCode(status) shouldBe world("status")
  }

  Then("""^The http body is:$"""){ (jsonBody:String) =>
    world("service") match {
      case "Customer" =>
        val customers = Json.parse(world("body")).as[Seq[Customer]]
        val customersExpected = Json.parse(jsonBody).as[Seq[Customer]]
        customersExpected shouldBe customers
      case "Accountant" =>
        val accountant = Json.parse(world("body")).as[Accountant]
        val accountantExpected = Json.parse(jsonBody).as[Accountant]
        accountantExpected shouldBe accountant
      case _ => throw new IllegalArgumentException("Service not defined")
    }
  }

  val statusCode = Map(
    "OK" -> "200",
    "NOT FOUND" -> "404"
  )

  def GET(url: String, header: (String, String)*): (String, String) = {
    Try(HttpClient(url).headers(header).asString) match {
      case Success(resp) => (resp.code.toString, resp.body)
      case Failure(ex) => println(s"Problem getting URL $url: ${ex.getMessage}"); throw ex
    }
  }
}
