package com.demo.DemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {

	public WebDriver driver;
	ExtentReports extent;
	ExtentTest testName;
	ExtentHtmlReporter reporter;

	@BeforeMethod
	public void setup() {
		reporter = new ExtentHtmlReporter("./Reports/learnreporting.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test() {
		testName = extent.createTest("Login Test");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		extent.flush();
		driver.close();
	}
}
