
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/book-keeping/conf/routes
// @DATE:Mon May 02 16:24:45 BST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAccountController AccountController = new controllers.ReverseAccountController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAccountController AccountController = new controllers.javascript.ReverseAccountController(RoutesPrefix.byNamePrefix());
  }

}
