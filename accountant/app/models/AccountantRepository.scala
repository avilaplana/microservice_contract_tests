package models

import javax.inject.{Inject, Singleton}

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AccountantRepository @Inject()(implicit ec: ExecutionContext) {

  val accountants: mutable.Buffer[Accountant] = mutable.ListBuffer(
    Accountant("Smith accountants", "0123456789", 10, "London"),
    Accountant("Local accountants", "098764321", 20, "Paris")
  )

  def findByLicense(license: String): Future[Option[Accountant]] = Future {
    accountants.find(_.license == license)
  }

  def create(acc: Accountant) = Future {
    accountants += acc
    acc
  }
}
