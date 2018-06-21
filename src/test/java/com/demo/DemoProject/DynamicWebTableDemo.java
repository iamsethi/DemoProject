package com.demo.DemoProject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicWebTableDemo {
	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void test() throws Exception {
		driver.get("http://money.rediff.com/gainers/bsc/dailygroupa?");
		List<WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));

		for (int i = 1; i < rows.size(); i++) {
			System.out.println(
					driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + i + "]")).getText());
		}

		System.out.println("<<<<<<<<<End>>>>>>>>>>");

		for (int i = 1; i < columns.size(); i++) {
			System.out.println(
					driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th[" + i + "]")).getText());
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
