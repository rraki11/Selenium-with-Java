package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _10_Alerts_handling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		String BravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
		ChromeOptions options = new ChromeOptions();
		options.setBinary(BravePath);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		Thread.sleep(3000);
		
		// Handling alert box
		driver.findElement(By.id("alertBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // accept = to click OK
		System.out.println(driver.findElement(By.id("output")).getText());
		Thread.sleep(2000);
		
		// Handling confirm box
		driver.findElement(By.id("confirmBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss(); // dismiss = to  click CANCEL
		System.out.println(driver.findElement(By.id("output")).getText());
		Thread.sleep(2000);
		
		// Handling prompt box
		driver.findElement(By.id("promptBox")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Hi, Im Shubh"); // enters the given prompt/text
		driver.switchTo().alert().accept(); // accept = to click OK
		System.out.println(driver.findElement(By.id("output")).getText());
		Thread.sleep(2000);

		System.out.println("Brave is about to close");
		driver.quit();
	}

}
