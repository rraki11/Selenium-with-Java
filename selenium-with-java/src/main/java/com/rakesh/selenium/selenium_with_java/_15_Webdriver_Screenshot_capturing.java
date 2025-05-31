package com.rakesh.selenium.selenium_with_java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _15_Webdriver_Screenshot_capturing {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		
		TakesScreenshot tS = (TakesScreenshot) driver;
		File sourceFile = tS.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./Screenshots/webdriverscreenshot.jpg");
		FileUtils.copyFile(sourceFile,destinationFile);
		System.out.println("Screenshot taken through BYTES saved in \"Screenshot folder\" Successfully");
		
		driver.quit();
	}

}
