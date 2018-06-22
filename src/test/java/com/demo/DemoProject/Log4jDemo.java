package com.demo.DemoProject;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Log4jDemo {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Log4jDemo.class);

	@BeforeMethod
	public void setUp() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		log.info("Window Maximized");

	}

	@Test
	public void test() {

		log.debug("Now hitting Amazon server");
		driver.get("https://www.amazon.com/");
		log.info("Landed on amazon home page");
		driver.get("http://jqueryui.com/demos/droppable/");
		log.debug("Getting the frames count");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		log.info("Frames count retreived");
		try {
			driver.switchTo().frame(0);
			log.info("Successfully switched to frame");
		} catch (Exception e) {
			log.error("Cannot identify the frame");
		}
		log.debug("Identifying Draggable objects");
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(draggable, droppable).build().perform();
		log.info("Drag and drop success");

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
