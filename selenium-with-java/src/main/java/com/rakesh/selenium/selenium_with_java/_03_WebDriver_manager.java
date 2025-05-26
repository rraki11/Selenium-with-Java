package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _03_WebDriver_manager {

	public static void main(String[] args) {

		// Before using WebDriverManager, make sure its dependency is added in your pom.xml (for Maven)
		// WebDriverManager helps automatically download the correct browser driver version for you.
		// This means you don’t have to manually download and set the path to the browser driver.

		// Automatically sets up the ChromeDriver based on the installed version of Chrome browser.
		WebDriverManager.chromedriver().setup(); 

		/*
		 * If you're working in a network environment with proxy restrictions (like in some companies),
		 * you can configure the proxy as shown below:
		 * "WebDriverManager.chromedriver().proxy("your-proxy-host:port").setup();"
		 */

		// Launch a new Chrome browser instance
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();

		// Open Google's homepage
		driver.get("https://google.com/");

		// Close the browser
		driver.quit();
	}
}
