package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _25_JavaScriptExecutor {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor jsexe = (JavascriptExecutor) driver;
		jsexe.executeScript("document.getElementById('email').value='Identified by Id';");
		jsexe.executeScript("document.getElementsByName('email')[0];");
	}

}
