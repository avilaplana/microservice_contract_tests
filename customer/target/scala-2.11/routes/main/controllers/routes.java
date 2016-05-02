
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/alvarovilaplana/projects/microservice_contract_tests/customer/conf/routes
// @DATE:Mon May 02 16:11:01 BST 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHealthController HealthController = new controllers.ReverseHealthController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCustomerController CustomerController = new controllers.ReverseCustomerController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHealthController HealthController = new controllers.javascript.ReverseHealthController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCustomerController CustomerController = new controllers.javascript.ReverseCustomerController(RoutesPrefix.byNamePrefix());
  }

}
