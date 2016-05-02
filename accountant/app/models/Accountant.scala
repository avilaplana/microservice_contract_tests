package models

import org.joda.time.DateTime
import play.api.libs.json.Json

case class Accountant(name: String, license: String, employees: Int = 10, basedOn: String = "London")

object Accountant {
  implicit val fmtAccountant = Json.format[Accountant]
}

