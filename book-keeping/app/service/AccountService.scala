package service

import javax.inject.{Inject, Singleton}

import gateway.{AccountantGateway, CustomerGateway}
import models.Account

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class AccountService @Inject()(accGateway: AccountantGateway, custGateway: CustomerGateway)
                              (implicit ec: ExecutionContext) {

  def details(license: String): Future[Option[Account]] = {
    accGateway.findByLicense(license) flatMap {
      case Some(accountant) => custGateway.all map { customers =>
        Some(Account(accountant, customers))
      }
      case None => Future.successful(Option.empty[Account])
    }
  }
}
