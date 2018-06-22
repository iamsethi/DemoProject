package com.demo.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefinition {
	public WebDriver driver;

	@Given("I am on Amazon page")
	public void i_am_on_Amazon_page() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

	}

	@When("I search for product")
	public void i_search_for_product() {
		WebElement tbx = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tbx.sendKeys("Amazon Fire TV Stick");
		driver.findElement(By.className("nav-input")).click();

	}

	@When("I search for \"(.*)\"")
	public void i_search_for(String product) {
		WebElement tbx = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tbx.sendKeys(product);
		driver.findElement(By.className("nav-input")).click();

	}

	@Then("I should be able to see the product on product listing page")
	public void i_should_be_able_to_see_the_product_on_product_listing_page() {

		Assert.assertEquals("Amazon Fire TV Stick with Voice Remote | Streaming Media Player",
				driver.findElement(By.xpath("//a[contains(@title,'Amazon Fire TV Stick')]")).getText());
		driver.quit();
	}
}