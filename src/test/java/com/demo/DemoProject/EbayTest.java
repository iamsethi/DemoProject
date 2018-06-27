package com.demo.DemoProject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayTest {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = GridDemo.getDriver();

	}

	@Test
	public void testGrid() {
		WebElement tbx = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tbx.sendKeys("Amazon Fire TV Stick");
		driver.findElement(By.className("nav-input")).click();
		Assert.assertEquals("Amazon Fire TV Stick with Voice Remote | Streaming Media Player",
				driver.findElement(By.xpath("//a[contains(@title,'Amazon Fire TV Stick')]")).getText());

	}

}
