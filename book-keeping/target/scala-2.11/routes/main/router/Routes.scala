
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/book-keeping/conf/routes
// @DATE:Mon May 02 16:24:45 BST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  AccountController_0: controllers.AccountController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    AccountController_0: controllers.AccountController
  ) = this(errorHandler, AccountController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AccountController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/""" + "$" + """license<[^/]+>""", """controllers.AccountController.accountantDetails(license:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_AccountController_accountantDetails0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/"), DynamicPart("license", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_accountantDetails0_invoker = createInvoker(
    AccountController_0.accountantDetails(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "accountantDetails",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """account/""" + "$" + """license<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_AccountController_accountantDetails0_route(params) =>
      call(params.fromPath[String]("license", None)) { (license) =>
        controllers_AccountController_accountantDetails0_invoker.call(AccountController_0.accountantDetails(license))
      }
  }
}
