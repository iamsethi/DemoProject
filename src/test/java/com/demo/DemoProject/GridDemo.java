package com.demo.DemoProject;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
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
	private static Logger logger = LogManager.getLogger(GridDemo.class);

	@BeforeMethod
	@Parameters({ "browser" })
	public void setUp(String browser) {
		PropertyConfigurator.configure("log4j.properties");
		baseURL = "https://www.amazon.in/";
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
			}
		}

		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}

	@Test
	public void testGrid() {
		WebElement tbx = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tbx.sendKeys("Amazon Fire TV Stick");
		driver.findElement(By.className("nav-input")).click();
		Assert.assertEquals("Amazon Fire TV Stick with Voice Remote | Streaming Media Player",
				driver.findElement(By.xpath("//a[contains(@title,'Amazon Fire TV Stick')]")).getText());

	}

	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}

}