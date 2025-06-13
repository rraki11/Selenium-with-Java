package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _23_Mouse_actions {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/shubh/selenium-profile");
		options.addArguments("profile-directory=default");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/ref=nav_logo");
		
		Actions actions = new Actions(driver);
		
		// mouse hover = moveToElement()
		actions.moveToElement(driver.findElement(By.id("icp-nav-flyout"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Change' and @class='icp-flyout-change']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//input[@class='a-button-input'])")).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("alexa");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).submit();
		
		// double click = doubleClick()
		actions.doubleClick(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).perform();
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		// right click = contextClick()
		actions.contextClick(driver.findElement(By.xpath("//span[.='right click me']"))).perform();
		

	}

}
