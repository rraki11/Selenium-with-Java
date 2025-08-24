package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
		Thread.sleep(2000);
		// finding element by Name and passing a value
		jsExecutor.executeScript("document.getElementsByName(\"email\")[0].value='found by Name';");
		Thread.sleep(2000);
		//finding element by TagName and passing a value
		jsExecutor.executeScript("document.getElementsByTagName(\"input\")[2].value='found by Tagname';"); 
		Thread.sleep(2000);
		//finding element by ClassName and passing a value 
		jsExecutor.executeScript("document.getElementsByClassName(\"inputtext\")[0].value='found by Classname';");
		Thread.sleep(2000);
		//finding element by CSS selector and passing a value
		jsExecutor.executeScript("document.querySelector(\"#email\").value='found by CssSelector';");
		Thread.sleep(2000);
		//finding element by xpath and passing a value
		jsExecutor.executeScript("document.evaluate(\"//input[@id='email']\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.value='found by xpath';");
		Thread.sleep(2000);
		
		// finding and clicking 
		jsExecutor.executeScript("document.getElementsByName(\"login\")[0].click();");
		
		// highlighting using javascript executor 
		Thread.sleep(2000);
		jsExecutor.executeScript("document.getElementsByName(\"login\")[0].style.border='3px black solid';"); //highlighting using border style attribute
		
		Thread.sleep(2000);
		jsExecutor.executeScript("document.getElementsByName(\"email\")[0].style.background='lightblue';"); //highlighting using background style attribute
		
		Thread.sleep(2000);
		jsExecutor.executeScript("document.getElementsByName(\"pass\")[0].setAttribute('style','border:3px black solid;background:lightblue');"); //hgihlighting using both styles by setAttribute
		
		// Scrolling by using JavaScript Executor
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		Thread.sleep(2000);
		// window.scrollTo(x,y)
		jsExecutor.executeScript("window.scrollTo(0,500);");
		
		Thread.sleep(2000);
		// window.scrollBy(x,y)
		jsExecutor.executeScript("window.scrollBy(0,500);");
		
		Thread.sleep(2000);
		// window.scrollIntoView()
		jsExecutor.executeScript("document.getElementById('first_date_picker').scrollIntoView();");
		
		Thread.sleep(2000);
		// Highlighting by using javaScriptExecutor arguments and webelement object
		driver.navigate().to("https://www.facebook.com/");
		Thread.sleep(2000);
		
		WebElement emailElement = driver.findElement(By.id("email"));
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:3px black solid;background:lightblue');", emailElement);
		Thread.sleep(2000);
		
		driver.close();
    }
}
