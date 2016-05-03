
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/customer/conf/routes
// @DATE:Tue May 03 23:29:22 BST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:5
  class ReverseHealthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def ping: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HealthController.ping",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customer/ping"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseCustomerController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def find: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CustomerController.find",
      """
        function(passport0,name1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customer" + _qS([(""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("passport", passport0), (""" + implicitly[QueryStringBindable[Option[String]]].javascriptUnbind + """)("name", name1)])})
        }
      """
    )
  
    // @LINE:7
    def findAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CustomerController.findAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "customers"})
        }
      """
    )
  
  }


}
