package models

import play.api.libs.json._

case class Address(street: String, doorNumber: String, flatNumber: String)

object Address {
  implicit val fmtAddress = Json.format[Address]
}


case class Customer(name: String, suraname: String, passport: String, address: Address)

object Customer {
  implicit val fmtCustomer = Json.format[Customer]
}

