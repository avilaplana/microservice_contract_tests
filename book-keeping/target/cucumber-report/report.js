$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("accountant_contract.feature");
formatter.feature({
  "line": 1,
  "name": "Contract test for Accountant microservice",
  "description": "",
  "id": "contract-test-for-accountant-microservice",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "The \u0027Accountant\u0027 microservice is up and running",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Accountant",
      "offset": 5
    }
  ],
  "location": "Steps.scala:16"
});
formatter.result({
  "duration": 127174265,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Details of accountant",
  "description": "",
  "id": "contract-test-for-accountant-microservice;details-of-accountant",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I request \u0027GET\u0027 to the resource \u0027/accountant/0123456789\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "The http response is \u0027OK\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The http body is:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 11,
    "value": "  {\n    \"name\": \"Smith accountants\",\n    \"license\": \"0123456789\"\n  }"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "/accountant/0123456789",
      "offset": 33
    }
  ],
  "location": "Steps.scala:33"
});
formatter.result({
  "duration": 4978389,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OK",
      "offset": 22
    }
  ],
  "location": "Steps.scala:48"
});
formatter.result({
  "duration": 96369,
  "status": "passed"
});
formatter.match({
  "location": "Steps.scala:52"
});
formatter.result({
  "duration": 204472892,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "The \u0027Accountant\u0027 microservice is up and running",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Accountant",
      "offset": 5
    }
  ],
  "location": "Steps.scala:16"
});
formatter.result({
  "duration": 2260375,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Details of accountant not found",
  "description": "",
  "id": "contract-test-for-accountant-microservice;details-of-accountant-not-found",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I request \u0027GET\u0027 to the resource \u0027/accountant/9876543123\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "The http response is \u0027NOT FOUND\u0027",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "/accountant/9876543123",
      "offset": 33
    }
  ],
  "location": "Steps.scala:33"
});
formatter.result({
  "duration": 2291657,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "NOT FOUND",
      "offset": 22
    }
  ],
  "location": "Steps.scala:48"
});
formatter.result({
  "duration": 70644,
  "status": "passed"
});
formatter.uri("customer_contract.feature");
formatter.feature({
  "line": 1,
  "name": "Contract test for Customer microservice",
  "description": "",
  "id": "contract-test-for-customer-microservice",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "The \u0027Customer\u0027 microservice is up and running",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Customer",
      "offset": 5
    }
  ],
  "location": "Steps.scala:16"
});
formatter.result({
  "duration": 2853334,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "List of customers",
  "description": "",
  "id": "contract-test-for-customer-microservice;list-of-customers",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "I request \u0027GET\u0027 to the resource \u0027/customers\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "The http response is \u0027OK\u0027",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "The http body is:",
  "keyword": "And ",
  "doc_string": {
    "content_type": "",
    "line": 11,
    "value": "  [{\n      \"name\":\"jhon\",\n      \"suraname\":\"travolta\",\n      \"passport\":\"0123456789\"\n    },\n   {\n     \"name\":\"kevin\",\n     \"suraname\":\"spacey\",\n     \"passport\":\"098765432\"\n   }]"
  }
});
formatter.match({
  "arguments": [
    {
      "val": "/customers",
      "offset": 33
    }
  ],
  "location": "Steps.scala:33"
});
formatter.result({
  "duration": 2170405,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "OK",
      "offset": 22
    }
  ],
  "location": "Steps.scala:48"
});
formatter.result({
  "duration": 67379,
  "status": "passed"
});
formatter.match({
  "location": "Steps.scala:52"
});
formatter.result({
  "duration": 13629524,
  "status": "passed"
});
});