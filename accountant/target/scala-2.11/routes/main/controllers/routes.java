
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/accountant/conf/routes
// @DATE:Tue May 03 23:29:05 BST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHealthController HealthController = new controllers.ReverseHealthController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAccountantController AccountantController = new controllers.ReverseAccountantController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHealthController HealthController = new controllers.javascript.ReverseHealthController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAccountantController AccountantController = new controllers.javascript.ReverseAccountantController(RoutesPrefix.byNamePrefix());
  }

}
