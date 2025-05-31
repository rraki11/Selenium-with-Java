package com.rakesh.selenium.selenium_with_java;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _16_PageLoadTimeout {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Older version
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		// Set the page load timeout to 5 seconds (new way using Duration class)
		// If any page takes more than 5 seconds to load, it will throw TimeoutException
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		// Start tracking time before opening the website
		Instant startTime = Instant.now();
		System.out.println("Start Time: " + startTime.toString());

		// Open Google (usually loads fast, should not throw error)
		driver.get("https://google.com/");

		// If you try a slower site like YouTube or your own test server, it might timeout
		// driver.get("https://youtube.com/");

		// End time after the page loads
		Instant endTime = Instant.now();
		System.out.println("End Time: " + endTime.toString());

		// Calculate how long it took to load the page
		Duration duration = Duration.between(startTime, endTime);
		System.out.println("Page load time: " + duration.toMillis() + " milliseconds");

		// Close the browser
		driver.quit();
	}
}