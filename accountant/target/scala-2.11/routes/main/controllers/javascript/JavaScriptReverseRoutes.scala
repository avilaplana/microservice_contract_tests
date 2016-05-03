
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/accountant/conf/routes
// @DATE:Tue May 03 23:29:05 BST 2016

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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accountant/ping"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseAccountantController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountantController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "accountant"})
        }
      """
    )
  
    // @LINE:7
    def findByLicense: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountantController.findByLicense",
      """
        function(license0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "accountant/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("license", encodeURIComponent(license0))})
        }
      """
    )
  
  }


}
