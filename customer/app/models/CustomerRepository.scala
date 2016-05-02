package models

import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class CustomerRepository @Inject()(implicit ec: ExecutionContext) {

  val customers = Seq(
    Customer("jhon", "travolta", "0123456789", Address("Oak hill", "12", "67")),
    Customer("kevin", "spacey", "098765432", Address("Santos road", "1", "5"))
  )

  def findByPassport(passport: String): Future[Option[Customer]] = Future {
    customers.find(_.passport == passport)
  }

  def findAll: Future[Seq[Customer]] = Future {
    customers
  }

  def findByName(name: String): Future[Option[Customer]] = Future {
    customers.find(_.name == name)
  }

  def find(name: String, passport: String): Future[Option[Customer]] = Future {
    customers.find(c => c.name == name && c.passport == passport)
  }

}
