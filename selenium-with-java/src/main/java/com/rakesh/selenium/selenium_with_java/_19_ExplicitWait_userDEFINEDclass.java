package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _19_ExplicitWait_userDEFINEDclass {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Creating WebDriverWait with:
		// - max wait time: 10 seconds
		// - polling interval: 500 milliseconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));


		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		
		driver.findElement(By.id("btn1")).click();
		
		// Defining a custom function to check if the element becomes visible
		Function<WebDriver, Boolean> f = new Function<WebDriver, Boolean>() {
			@Override
			public Boolean apply(WebDriver t) {
				// Returns true only when the element is present and visible
				return t.findElement(By.id("txt1")).isDisplayed();
			}
		};
		// Using user-defined condition in WebDriverWait
		wait.until(f);
		driver.findElement(By.id("txt1")).sendKeys("1 2 3 testing mick hlo");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}