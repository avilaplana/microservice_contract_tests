
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/customer/conf/routes
// @DATE:Mon May 02 16:11:01 BST 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HealthController_0: controllers.HealthController,
  // @LINE:7
  CustomerController_1: controllers.CustomerController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HealthController_0: controllers.HealthController,
    // @LINE:7
    CustomerController_1: controllers.CustomerController
  ) = this(errorHandler, HealthController_0, CustomerController_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HealthController_0, CustomerController_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ping""", """controllers.HealthController.ping"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """customers""", """controllers.CustomerController.findAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """customer""", """controllers.CustomerController.find(passport:Option[String], name:Option[String])"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HealthController_ping0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ping")))
  )
  private[this] lazy val controllers_HealthController_ping0_invoker = createInvoker(
    HealthController_0.ping,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HealthController",
      "ping",
      Nil,
      "GET",
      """""",
      this.prefix + """ping"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_CustomerController_findAll1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("customers")))
  )
  private[this] lazy val controllers_CustomerController_findAll1_invoker = createInvoker(
    CustomerController_1.findAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CustomerController",
      "findAll",
      Nil,
      "GET",
      """""",
      this.prefix + """customers"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CustomerController_find2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("customer")))
  )
  private[this] lazy val controllers_CustomerController_find2_invoker = createInvoker(
    CustomerController_1.find(fakeValue[Option[String]], fakeValue[Option[String]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CustomerController",
      "find",
      Seq(classOf[Option[String]], classOf[Option[String]]),
      "GET",
      """""",
      this.prefix + """customer"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HealthController_ping0_route(params) =>
      call { 
        controllers_HealthController_ping0_invoker.call(HealthController_0.ping)
      }
  
    // @LINE:7
    case controllers_CustomerController_findAll1_route(params) =>
      call { 
        controllers_CustomerController_findAll1_invoker.call(CustomerController_1.findAll)
      }
  
    // @LINE:9
    case controllers_CustomerController_find2_route(params) =>
      call(params.fromQuery[Option[String]]("passport", None), params.fromQuery[Option[String]]("name", None)) { (passport, name) =>
        controllers_CustomerController_find2_invoker.call(CustomerController_1.find(passport, name))
      }
  }
}
