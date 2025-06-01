package com.rakesh.selenium.selenium_with_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * An Implicit Wait is a Selenium mechanism that tells the WebDriver to wait for a certain amount of    time when trying to find an element if it's not immediately available. 
 * It applies globally — to every findElement() or findElements() call
 */

public class _17_ImplicitWaitTimout {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Once it is intialized it will mean for whole browser like, pageLoadTimeout did.
		// Set an implicit wait timeout of 6 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		// Resize the browser window to 500x900
		driver.manage().window().setSize(new Dimension(500, 900));
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.id("btn1")).click();

		// Once the textbox appears, send the text 'Shubham' to the input with ID 'txt1'
		driver.findElement(By.id("txt1")).sendKeys("Shubham");
		Thread.sleep(3000);

		driver.quit();
	}
}