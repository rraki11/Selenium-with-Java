package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _27_JavascriptExecutor {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		
		// finding element by ID and passing a Value using java script executor
		jsExecutor.executeScript("document.getElementById(\"email\").value='found by ID';");
		Thread.sleep(3000);
		// finding element by Name and passing a value
		jsExecutor.executeScript("document.getElementsByName(\"email\")[0].value='found by Name';");
		Thread.sleep(3000);
		//finding element by TagName and passing a value
		jsExecutor.executeScript("document.getElementsByTagName(\"input\")[2].value='found by Tagname';"); 
		Thread.sleep(3000);
		//finding element by ClassName and passing a value 
		jsExecutor.executeScript("document.getElementsByClassName(\"inputtext\")[0].value='found by Classname';");
		Thread.sleep(3000);
		//finding element by CSS selector and passing a value
		jsExecutor.executeScript("document.querySelector(\"#email\").value='found by CssSelector';");
		Thread.sleep(3000);
		//finding element by xpath and passing a value
		jsExecutor.executeScript("document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value='found by xpath';");
		
		// finding and clicking 
		jsExecutor.executeScript("document.getElementsByName(\"login\")[0].click();");
		
		
    }
}
