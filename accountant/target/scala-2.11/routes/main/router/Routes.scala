
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/accountant/conf/routes
// @DATE:Tue May 03 23:29:05 BST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HealthController_1: controllers.HealthController,
  // @LINE:7
  AccountantController_0: controllers.AccountantController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HealthController_1: controllers.HealthController,
    // @LINE:7
    AccountantController_0: controllers.AccountantController
  ) = this(errorHandler, HealthController_1, AccountantController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HealthController_1, AccountantController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """accountant/ping""", """controllers.HealthController.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """accountant/""" + "$" + """license<[^/]+>""", """controllers.AccountantController.findByLicense(license:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """accountant""", """controllers.AccountantController.create()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HealthController_ping0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("accountant/ping")))
  )
  private[this] lazy val controllers_HealthController_ping0_invoker = createInvoker(
    HealthController_1.ping,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HealthController",
      "ping",
      Nil,
      "GET",
      """""",
      this.prefix + """accountant/ping"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_AccountantController_findByLicense1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("accountant/"), DynamicPart("license", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountantController_findByLicense1_invoker = createInvoker(
    AccountantController_0.findByLicense(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountantController",
      "findByLicense",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """accountant/""" + "$" + """license<[^/]+>"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AccountantController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("accountant")))
  )
  private[this] lazy val controllers_AccountantController_create2_invoker = createInvoker(
    AccountantController_0.create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountantController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """accountant"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HealthController_ping0_route(params) =>
      call { 
        controllers_HealthController_ping0_invoker.call(HealthController_1.ping)
      }
  
    // @LINE:7
    case controllers_AccountantController_findByLicense1_route(params) =>
      call(params.fromPath[String]("license", None)) { (license) =>
        controllers_AccountantController_findByLicense1_invoker.call(AccountantController_0.findByLicense(license))
      }
  
    // @LINE:9
    case controllers_AccountantController_create2_route(params) =>
      call { 
        controllers_AccountantController_create2_invoker.call(AccountantController_0.create())
      }
  }
}
