package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _06_HandleBasic_HTMLelements {

	public static void main(String[] args) throws InterruptedException {
		
		//In this program we will be handling basic elements such as Radio Buttons, Buttons, Link texts, Check box 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("radio1")).click(); //clicks the radio button whos ID is radio1
		Thread.sleep(2000);
		WebElement female = driver.findElement(By.id("radio2"));
		female.click(); //clicks the radio button whos ID is radio2
		Thread.sleep(2000);
		if (female.isSelected()) {
			driver.findElement(By.id("radio1")).click();
			Thread.sleep(2000);
		} else {
			System.out.println("there is nothing to click..");
		}
		
		WebElement orangechk = driver.findElement(By.id("checkbox1"));
		WebElement bluechk = driver.findElement(By.id("checkbox2"));
		if (orangechk.isSelected()) {
			orangechk.click(); //it was already selected but I clicked again to unselect it
			Thread.sleep(2000);
			bluechk.click();
			Thread.sleep(2000);
		} else {
			System.out.println("elements not found..");
		}
		
		driver.findElement(By.id("prompt")).click(); //clicks on the prompt
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("Hello Prompt"); //after clicking on the prompt text will be netered 
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Blogger")).click(); //clicks on the link
		Thread.sleep(10000);
		
		driver.quit();
	}

}

//We use "element.isSelected()" for Radio Buttons and Checkboxes 
//-> It checks whether the element is currently selected (true/false).
//-> Not applicable to buttons or text fields.

//We use "element.isEnabled()" to check if an element (like a button, input box, etc.) is interactable
//-> If it returns false, the element is disabled (e.g., grayed out).

//We use "element.isDisplayed()" to verify if the element is visible on the webpage
//-> Useful to check whether an element is present and viewable in the current DOM.
