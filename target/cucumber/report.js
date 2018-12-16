$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/math.feature");
formatter.feature({
  "name": "Math operations",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Can add two  numbers",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "number is 1",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNumbers.number_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "number is 2",
  "keyword": "And "
});
formatter.match({
  "location": "AddNumbers.number_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add numbers",
  "keyword": "When "
});
formatter.match({
  "location": "AddNumbers.i_add_numbers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get 3 in result",
  "keyword": "Then "
});
formatter.match({
  "location": "AddNumbers.i_get_in_result(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Can add two  numbers",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "number is \u003cfirst_added\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "number is \u003csecond_added\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I add numbers",
  "keyword": "When "
});
formatter.step({
  "name": "I get \u003cresult\u003e in result",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "first_added",
        "second_added",
        "result"
      ]
    },
    {
      "cells": [
        "2",
        "2",
        "4"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Can add two  numbers",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "number is 2",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNumbers.number_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "number is 2",
  "keyword": "Given "
});
formatter.match({
  "location": "AddNumbers.number_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I add numbers",
  "keyword": "When "
});
formatter.match({
  "location": "AddNumbers.i_add_numbers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get 4 in result",
  "keyword": "Then "
});
formatter.match({
  "location": "AddNumbers.i_get_in_result(int)"
});
formatter.result({
  "status": "passed"
});
});