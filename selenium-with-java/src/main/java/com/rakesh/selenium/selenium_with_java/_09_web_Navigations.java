package com.rakesh.selenium.selenium_with_java;

import java.lang.foreign.Linker.Option;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _09_web_Navigations {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
		ChromeOptions options = new ChromeOptions();
		options.setBinary(bravePath);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://google.com/");
		System.out.println("Brave opened: " + driver.getTitle());
		Thread.sleep(3000);
		
		driver.findElement(By.id("APjFqb")).sendKeys("Shubham Routray");
		Thread.sleep(3000);
		driver.findElement(By.id("APjFqb")).submit();
		Thread.sleep(3000);
		
		driver.get("https://youtube.com/");
		Thread.sleep(3000);
		
		driver.get("https://facebook.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("sampleemail@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys("12345");
		Thread.sleep(3000);
		
		driver.navigate().refresh(); //refresh the page
		Thread.sleep(3000);
		
		driver.navigate().back(); //navigates to one page backward (previous page)
		Thread.sleep(3000);
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward(); //navigates to one page forward (next page)
		Thread.sleep(3000);
		
		driver.navigate().to("https://google.com/"); //navigate to the spefied URL
		Thread.sleep(3000);
		
		System.out.println("Brave is about to close");
		driver.quit();
		
		

	}

}
