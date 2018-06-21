package com.demo.DemoProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoITDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() throws IOException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test() throws Exception {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/ketan.sethi/eclipse-workspace/DemoProject/data/fileupload.html");
		driver.findElement(By.id("1")).click();
		Runtime.getRuntime().exec("blogUpload.exe");
		// https://www.autoitscript.com/site/autoit/downloads/
		// First two Download Auto IT and Download Editor
		//Go to C->Program Files -> AutoIT
		//Open AU3Info ->Its a identifier tool
		//Go to SCITE Folder -> open scite.exe
		// ControlFocus("File Upload","","Edit1")
		// Window Title Control ID is combination of class + instance
		//
		// ControlSetText("File Upload","","Edit1","Path of the file we want to upload")
		// Window Title Control ID is combination of class + instance
		//
		// ControlClick("File Upload","","Button1")
		// Window Title Control ID of button
		//
		// Save it
		// Right Click and compile as x86 or x64

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
