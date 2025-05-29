package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _12_singleTab_handling {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String parentTab = driver.getWindowHandle(); 
		System.out.println("Parent tab Id: " + parentTab 
				                             + " | Title: " + driver.getTitle());
		
		Thread.sleep(3000);
		driver.findElement(By.id("newTabBtn")).click();
		
		// Get all currently open window handles (parent + new)
		Set<String> tabHandles = driver.getWindowHandles();
				
		// Print the handle and title of each open window
		for (String allTabs : tabHandles) {
			System.out.println("Window/Tab Handle: " + allTabs + 
					                   " | Current Window/Tab Title: " + driver.getTitle());
		}
		
		for(String allTabs : tabHandles ) {
			if (!allTabs.equals(parentTab)) {
				driver.switchTo().window(allTabs);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				driver.findElement(By.id("promptBox")).click();
				Thread.sleep(3000);
				
				driver.switchTo().alert().sendKeys("shubh");
				driver.switchTo().alert().accept();
				Thread.sleep(3000);
				
				driver.close();
			}
		}
		
		driver.switchTo().window(parentTab);
		driver.findElement(By.id("name")).sendKeys("hehehehehe");
		
		Thread.sleep(3000);
		driver.quit();
	}

}
