package com.demo.DemoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetCoordinatesDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test() throws Exception {

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement element = driver.findElement(By.className("hasDatepicker"));

		Point point = element.getLocation();
		int xcord = point.getX();
		int ycord = point.getY();

		Actions builder = new Actions(driver);
		builder.moveToElement(element, xcord, ycord).click().build().perform();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
