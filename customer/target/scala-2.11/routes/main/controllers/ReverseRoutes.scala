
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/customer/conf/routes
// @DATE:Tue May 03 23:29:22 BST 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHealthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def ping(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "customer/ping")
    }
  
  }

  // @LINE:7
  class ReverseCustomerController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def find(passport:Option[String], name:Option[String]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "customer" + queryString(List(Some(implicitly[QueryStringBindable[Option[String]]].unbind("passport", passport)), Some(implicitly[QueryStringBindable[Option[String]]].unbind("name", name)))))
    }
  
    // @LINE:7
    def findAll(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "customers")
    }
  
  }


}
