package com.demo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", tags = { "@DataDriven" }, plugin = { "pretty",
		"html:target/cucumber-reports" }, glue = { "com.dummy.stepdefinition" })

// json:target/cucumber-reports/Cucumber.json
// junit:targe/cucumber-reports/Cucumber.xml

public class TestRunner {

}