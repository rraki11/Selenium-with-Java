package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _21_ElementsProperties {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("shubham@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("blhabladfkjolakdf");
		
		// Print the tag name of the email input field
		System.out.println(driver.findElement(By.id("email")).getTagName()); 
		
		// Get the "type" attribute of the login button
		System.out.println(driver.findElement(By.name("login")).getAttribute("type"));
		
		// Get the "value" attribute of the email field
		// Note: This is dynamically created after you enter something in the input field
		System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
		
		// Get the "value" attribute of the password field
		System.out.println(driver.findElement(By.id("pass")).getAttribute("value"));
		
		// Get the CSS background-color of the login button
		System.out.println(driver.findElement(By.name("login")).getCssValue("background-color")); 
		// Output: rgb(...) depending on browser rendering

		driver.quit();

	}
}
