package com.rakesh.selenium.selenium_with_java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshots_practice {

	public static void main(String[] args) throws IOException {
		
		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Delete existing screenshots from previous runs
		deletescreenshot();
		
		driver.get("https://google.com/");
		String a = "./Screenshots/practice.jpg"; // Set file path to save Google screenshot
		screenshot(driver, a);  // Capture and save screenshot
		
		driver.get("https://youtube.com/");
		String b = "./Screenshots/practice2.jpg"; // Set file path to save YouTube screenshot
		screenshot(driver, b);  // Capture and save screenshot
		
		// Close the browser
		driver.quit();
	}

	// Method to take a screenshot and save it to the given path
	public static void screenshot(WebDriver x , String y) throws IOException {
		// Cast driver to TakesScreenshot interface
		TakesScreenshot tS = (TakesScreenshot) x;
		
		// Capture screenshot and store it as a temporary file
		File srcFile = tS.getScreenshotAs(OutputType.FILE);
		
		File dstFile = new File(y); // Destination file to store screenshot
		
		// Copy the temporary screenshot file to the desired destination
		FileUtils.copyFile(srcFile, dstFile);
		
		System.out.println("screenshot saved at: " + dstFile.getAbsolutePath());
	}
	
	// Method to delete old screenshots from the ./Screenshots directory
	public static void deletescreenshot() {
		File location = new File("./Screenshots");
		
		// Check if folder exists and is a directory
		if (location.exists() && location.isDirectory()) {
			// Loop through each file in the folder and delete it
			for (File folders : location.listFiles()) {
				folders.delete();
			}
			System.out.println("Previous screenshots deleted.");
		} else {
			System.out.println("No existing screenshots folder found.");
		}
	}
}