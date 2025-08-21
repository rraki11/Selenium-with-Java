package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _27_JavascriptExecutor {

	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement ele1 = (WebElement) jsExecutor.executeScript("document.getElementById(\"email\");");
	}

}
