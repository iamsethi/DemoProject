package com.demo.DemoProject;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class GridDemo {

	public static WebDriver driver;
	String baseURL;
	DesiredCapabilities capability;

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			try {
				driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), options);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
			options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			try {
				driver = new RemoteWebDriver(new URL("http://172.17.0.2:4444/wd/hub"), options);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}