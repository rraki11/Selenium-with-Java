package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _05_Handling_textboxex {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); //webdriver manager, loads driver automatically 
		WebDriver driver = new ChromeDriver(); //opens the browser
		driver.get("https://www.facebook.com/"); //opens facebook
		Thread.sleep(3000); //sleeps for 3sec = 3000ms
		
		//email UI element found by using locator
		WebElement emailElement = driver.findElement(By.id("email")); 
		
		//checks whether the eamil/username UI element is displayed or not
		if (emailElement.isDisplayed()) {
			
			//checks whether the email/username UI element is enabled or not
			if(emailElement.isEnabled()) {
				
				//enters the email/username as "automatedemail.com"
				emailElement.sendKeys("automatedemail.com");
				
				//store the entered username value in the "emailValue" variable and prints it on consol
				String emailValue = emailElement.getAttribute("value");
				System.out.println("entered text: " + emailValue);
				
				//sleeps for 3sec = 3000ms
				Thread.sleep(3000);
			} else {
				System.out.println("element for entering username/eamil is not enabled!");
			}
		} else {
			System.out.println("element for entering username/eamil is not displayed..");
		}
		
		//password UI element found by using locator
		WebElement passwordElement = driver.findElement(By.id("pass"));
		
		//checks whether the password UI element is displayed or not
		if (passwordElement.isDisplayed()) {
			
			//checks whether the password UI element is enabled or not
			if (passwordElement.isEnabled()) {
				
				//enters the password as "shubh"
				passwordElement.sendKeys("shubh");
				
				//store the entered password value in the "passvalue" variable and prints it on consol
				String passValue = passwordElement.getAttribute("value");
				System.out.println("entered password: " + passValue);
				Thread.sleep(3000);
				
				//clicks on the login button..
				WebElement loginElement = driver.findElement(By.name("login"));
				loginElement.click(); //clicks on the LOGIN button
				
				//sleeps for 3sec = 3000ms
				Thread.sleep(5000);
				driver.quit();
			} else {
				System.out.println("element for entering password is not enabled!");
			}
		} else {
			System.out.println("element for enetering password is not displayed..");
		}
			
		//clears the entered username/email value
		emailElement.clear();
		
		//clears the entered password value
		passwordElement.clear();
		
		//sleeps for 2sec = 2000ms
		Thread.sleep(2000);
		
		//closes the browser automatically
		driver.quit();
	}
}
