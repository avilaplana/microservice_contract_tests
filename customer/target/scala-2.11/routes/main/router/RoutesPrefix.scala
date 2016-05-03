
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/customer/conf/routes
// @DATE:Tue May 03 23:29:22 BST 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
