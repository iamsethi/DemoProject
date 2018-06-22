package com.demo.DemoProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridDemo {

	WebDriver driver;
	String baseURL;
	DesiredCapabilities capability;

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(String browser) throws MalformedURLException {
		baseURL = "https://www.google.com/";
		if (browser.equalsIgnoreCase("chrome")) {
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
		} else if (browser.equalsIgnoreCase("firefox")) {
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("chrome");
		}

		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void testLogin() throws InterruptedException {
		WebElement loginLink = driver.findElement(By.xpath("//a[contains(@href,'/sign_in')]"));
		loginLink.click();
		WebElement emailField = driver.findElement(By.id("user_email"));
		emailField.sendKeys("test@email.com");
		WebElement passwordField = driver.findElement(By.id("user_password"));
		passwordField.sendKeys("abcabc");
		WebElement loginButton = driver.findElement(By.name("commit"));
		loginButton.click();
	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}