package com.demo.DemoProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApachePOIDemo {

	public WebDriver driver;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sh;
	File src;
	private static Logger logger = LogManager.getLogger(ApachePOIDemo.class);

	@BeforeMethod
	public void setUp() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		src = new File("./data/file.xlsx");
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void testPOI() {
		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			logger.info(i);
			driver.get(sh.getRow(i).getCell(0).getStringCellValue());
			driver.manage().window().maximize();
			driver.findElement(By.cssSelector("#lst-ib")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.name("btnK")).click();
			sh.getRow(i).createCell(3).setCellValue(driver.getTitle());
			logger.info(driver.getTitle());
			if (driver.getTitle().equals(sh.getRow(i).getCell(2).getStringCellValue())) {
				sh.getRow(i).createCell(4).setCellValue("PASS");
			} else {
				sh.getRow(i).createCell(4).setCellValue("FAIL");
			}
		}

	}

	@AfterMethod
	public void tearDown() throws IOException, FileNotFoundException {

		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		driver.close();

	}
}
