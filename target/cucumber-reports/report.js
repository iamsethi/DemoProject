$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Product.feature");
formatter.feature({
  "name": "Login feature file",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Amazon"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify login functionality of customer",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@DataDriven"
    }
  ]
});
formatter.step({
  "name": "I am on Amazon page",
  "keyword": "Given "
});
formatter.step({
  "name": "I search for \"\u003cproduct\u003e\"",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "product"
      ]
    },
    {
      "cells": [
        "Apple iPhone X"
      ]
    },
    {
      "cells": [
        "Samsung"
      ]
    },
    {
      "cells": [
        "MI"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify login functionality of customer",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Amazon"
    },
    {
      "name": "@DataDriven"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on Amazon page",
  "keyword": "Given "
});
formatter.match({
  "location": "UserStepDefinition.i_am_on_Amazon_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"Apple iPhone X\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserStepDefinition.i_search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify login functionality of customer",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Amazon"
    },
    {
      "name": "@DataDriven"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on Amazon page",
  "keyword": "Given "
});
formatter.match({
  "location": "UserStepDefinition.i_am_on_Amazon_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"Samsung\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserStepDefinition.i_search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify login functionality of customer",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Amazon"
    },
    {
      "name": "@DataDriven"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on Amazon page",
  "keyword": "Given "
});
formatter.match({
  "location": "UserStepDefinition.i_am_on_Amazon_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for \"MI\"",
  "keyword": "When "
});
formatter.match({
  "location": "UserStepDefinition.i_search_for(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});