package com.demo.DemoProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalendarDemo {

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
		driver.findElement(By.className("hasDatepicker")).click();

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for (WebElement ele : allDates) {

			String date = ele.getText();
			if (date.equalsIgnoreCase("21")) {
				ele.click();
				break;
			}
		}
		Thread.sleep(10000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
