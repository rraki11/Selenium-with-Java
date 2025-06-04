package com.rakesh.selenium.selenium_with_java;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _22_XPath {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		chapter2(driver);
	}
	
	public static void chapter2 (WebDriver d) throws InterruptedException {
		d.get("https://www.youtube.com/watch?v=f0oCvbuXmJI&list=PLacgMXFs7kl_7BbV1p_KqDYM65Zm4L_HU&index=24");
		
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10), Duration.ofMillis(500));
		
		// Absolute xpath,	starts with single /
		// But not recommended to use oftenly
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div/form/input")));
		
		d.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div/form/input")).click();
		d.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div/form/input")).sendKeys("ethical hacking");
		d.findElement(By.xpath("/html/body/ytd-app/div[1]/div[2]/ytd-masthead/div[4]/div[2]/yt-searchbox/div/form/input")).submit();
		
		Thread.sleep(3000);
		
		// Relative xpath -> //tagname[@attribute='value']; 	starts wtih doulbe /
		// Mostly recommended to use 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search']")));
		
		d.findElement(By.xpath("//input[@placeholder='Search']")).click();
		d.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		d.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("cyber security");
		d.findElement(By.xpath("//input[@placeholder='Search']")).submit();
		
		Thread.sleep(5000);
		d.quit();
	} 
 
}
