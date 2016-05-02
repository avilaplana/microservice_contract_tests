Feature: Contract test for Customer microservice

  Background:
    Given The 'Customer' microservice is up and running


  Scenario: List of customers
    When I request 'GET' to the resource '/customers'
    Then The http response is 'OK'
    And The http body is:
    """
      [{
          "name":"jhon",
          "suraname":"travolta",
          "passport":"0123456789"
        },
       {
         "name":"kevin",
         "suraname":"spacey",
         "passport":"098765432"
       }]
    """
