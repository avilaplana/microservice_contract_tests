
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/book-keeping/conf/routes
// @DATE:Mon May 02 16:24:45 BST 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:5
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:5
  class ReverseAccountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def accountantDetails: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.accountantDetails",
      """
        function(license0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("license", encodeURIComponent(license0))})
        }
      """
    )
  
  }


}
