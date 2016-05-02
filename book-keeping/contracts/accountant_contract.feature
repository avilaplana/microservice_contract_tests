Feature: Contract test for Accountant microservice

  Background:
    Given The 'Accountant' microservice is up and running


  Scenario: Details of accountant
    When I request 'GET' to the resource '/accountant/0123456789'
    Then The http response is 'OK'
    And The http body is:
    """
      {
        "name": "Smith accountants",
        "license": "0123456789"
      }
    """

  Scenario: Details of accountant not found
    When I request 'GET' to the resource '/accountant/9876543123'
    Then The http response is 'NOT FOUND'
