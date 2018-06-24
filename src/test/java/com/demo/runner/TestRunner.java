package com.demo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", tags = { "@DataDriven" }, plugin = { "pretty",
		"html:target/cucumber-reports" }, glue = { "com.demo.stepdefinition" })

// cucumber-reports.json
// cucumber-reports.xml
// mvn clean install -Denvironment=stage -Dcucumber.options="--tags @stage1"
// -Dusername=ketan -Dbrowser=chrome

public class TestRunner {

}