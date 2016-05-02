package models

import play.api.libs.json.Json

case class Customer(name: String, suraname: String, passport: String)

object Customer {
  implicit val fmtCustomer = Json.format[Customer]
}

case class Accountant(name: String, license: String)

object Accountant {
  implicit val fmtAccountant = Json.format[Accountant]
}

case class Account(accountant: Accountant, customers: Seq[Customer])

object Account {
  implicit val fmtAccount = Json.format[Account]
}
