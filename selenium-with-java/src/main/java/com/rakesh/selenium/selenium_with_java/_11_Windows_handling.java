package com.rakesh.selenium.selenium_with_java;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _11_Windows_handling {

	public static void main(String[] args) throws InterruptedException {

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		
		// Set the path to Brave browser executable
		String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
		ChromeOptions options = new ChromeOptions();
		options.setBinary(bravePath);
		
		// Launch Brave browser using ChromeDriver
		WebDriver driver = new ChromeDriver(options);

		// Navigate to the test page
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();

		/*
		 * A Window Handle is a unique alphanumeric ID assigned to each browser tab or window.
		 * Selenium treats tabs and windows the same — both receive unique handles.
		 */
		
		// Store the handle of the current (parent) window
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window Handle: " + parentWindow + 
		                   " | Title: " + driver.getTitle());

		// Click button to open a new window
		driver.findElement(By.id("newWindowBtn")).click();

		// Get all currently open window handles (parent + new)
		Set<String> windowHandles = driver.getWindowHandles();

		// Print the handle and title of each open window
		for (String window : windowHandles) {
			System.out.println("Window Handle: " + window + 
			                   " | Current Window Title: " + driver.getTitle());
		}

		/*
		 * Switch to the child window and perform actions
		 * Then close it and switch back to the parent window
		 */
		for (String window : windowHandles) {
			if (!window.equals(parentWindow)) {
				// Switch control to child window
				driver.switchTo().window(window);
				driver.manage().window().maximize();

				// Perform actions in child window
				Thread.sleep(3000);
				driver.findElement(By.id("firstName")).sendKeys("Shubham");
				Thread.sleep(3000);
				driver.findElement(By.id("lastName")).sendKeys("Routray");
				Thread.sleep(3000);
				driver.findElement(By.id("clearbtn")).click();
				Thread.sleep(2500);

				// Close the child window
				driver.close();
			}
		}

		// Switch back to the parent window
		Thread.sleep(3000);
		driver.switchTo().window(parentWindow);

		// Perform action on the parent window
		driver.findElement(By.id("name")).sendKeys("HI HLO");

		// Wait and then quit browser
		Thread.sleep(3000);
		driver.quit();
	}
}
