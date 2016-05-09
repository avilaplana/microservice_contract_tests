Contract tests in a microservice environment
-------------------------------------------
I want to create a proof of concept about how I would develop contract tests against downstream microservices. 

The contract tests should check the following:

1. Infrastructure and integration
2. URL well formed
3. In the http request, the marshalling (object to json) satisfies the contract
4. In the http response, the unmarshalling (json to object) satisfies the contract
5. In the http request, headers satisfy the contract
6. In the http response, headers and status satisfy the contract
7. Happy and unhappy paths
8. They need to be run in CI against a producer service deployed in a stable environment (no stubs)

Example:
=======
I assume that we have 3 microservices:

1. **book-keeping**
2. **accountant**
3. **customer**

To simplify the problem we assume that **book-keeping** contains a public rest endpoint that provides information about an accountant. The data is the aggregation of information about the accountant got from **accountant** and information about all the customers got from **customer**.

![alt tag](https://github.com/avilaplana/microservice_contract_tests/blob/master/doc/microservice-contract.png)

The requests would be the following:

1. Inbound request to book-keeping: /account/:license
2. Outbound request to accountant: /accountant/:license
3. Outbound request to customer: /customers

The purpose of the contract test is to check that book-keeping  satisfy the contract with /accountant/:license and /customers providing quick feedback about the behaviour of those downstream services.

Contract test - Accountant
--------------------------
![alt tag](https://github.com/avilaplana/microservice_contract_tests/blob/master/doc/accountant_contract_test.png)

```
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

```

Contract test - Customer
--------------------------
![alt tag](https://github.com/avilaplana/microservice_contract_tests/blob/master/doc/customer_contract_test.png)
```
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

```

HOW TO RUN WITH DOCKER
=======================
```
1. docker-machine start default
2. export DOMAIN_BACKEND_MICROSERVICES=http://192.168.99.100
3. cd accountant
4. sbt dist
5. cd ..
6. cd  customer
7. sbt dist
8. cd ..
9. docker-compose rm -f
10. docker-compose up -d
11. cd book-keeping
12. sbt test
13. cd ..
14. docker-compose stop
15. docker-machine start default
```

HOW TO RUN WITH SBT
=======================
```
2. unset DOMAIN_BACKEND_MICROSERVICES
3. cd accountant
4. screen -d -m sbt "run 9001" 
5. cd ..
6. cd  customer
7. screen -d -m sbt "run 9002"
8. cd ..
11. cd book-keeping
12. sbt test
```

APPENDIX
========

Microservice book-keeping
-------------------------

Public Rest API with only an endpoint:

**GET        /account/:license**

Happy path - 200

```
{
   "accountant":{
      "name":"Smith accountants",
      "license":"0123456789"
   },
   "customers":[
      {
         "name":"jhon",
         "suraname":"travolta",
         "passport":"0123456789"
      },
      {
         "name":"kevin",
         "suraname":"spacey",
         "passport":"098765432"
      }
   ]
}
```

Unhappy path - 404

Microservice accountant
-----------------------

Backend microservice

**GET accountant/:license**

Happy path - 200

```
{
    name: "Smith accountants",
    license: "0123456789",
    employees: 10,
    basedOn: "London"
}
```

Unhappy path - 404

**POST        /accountant**

```
{
   "name":"Smith accountants 11",
   "license":"012345678912",
   "employees":10,
   "basedOn":"Berlin"
}
```

Happy path - 201

Unhappy path - 400


Microservice customer
---------------------

Backend microservice

**GET /customers**

Happy path - 200

```
[
   {
      "name":"jhon",
      "suraname":"travolta",
      "passport":"0123456789",
      "address":{
         "street":"Oak hill",
         "doorNumber":"12",
         "flatNumber":"67"
      }
   },
   {
      "name":"kevin",
      "suraname":"spacey",
      "passport":"098765432",
      "address":{
         "street":"Santos road",
         "doorNumber":"1",
         "flatNumber":"5"
      }
   }
]

```
