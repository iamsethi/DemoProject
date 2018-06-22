package com.demo.DemoProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoITDemo {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void test() throws Exception {

		driver.get("file:///C:/Users/ketan.sethi/eclipse-workspace/DemoProject/data/fileupload.html");
		driver.findElement(By.id("1")).click();
		Runtime.getRuntime().exec("C:/Users/ketan.sethi/Desktop/upload.exe");
		// https://www.autoitscript.com/site/autoit/downloads/
		// First two Download Auto IT and Download Editor
		// Go to C->Program Files -> AutoIT
		// Open AU3Info ->Its a identifier tool
		// Go to SCITE Folder -> open scite.exe
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
	public void tearDown() throws IOException {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:/Users/ketan.sethi/Desktop/snapshot.png"));
		driver.close();
	}
}
