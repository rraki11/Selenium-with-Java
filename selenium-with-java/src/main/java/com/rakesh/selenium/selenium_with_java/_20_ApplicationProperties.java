package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _20_ApplicationProperties {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.seleniumhq.org/");
		
		// Current URL
		System.out.println("Current URL: " +driver.getCurrentUrl());
		
		// Current page's Title
		System.out.println("Title: " + driver.getTitle());
		
		// Current page's page source
		System.out.println();
		System.out.println(driver.getPageSource());
		
		driver.quit();
		
	}

}
