package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _24_Calender_practice {

	public static void main(String[] args)throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		Actions action = new Actions(driver);
		int day = 23;
		
		//calender two
		Thread.sleep(3000);
		
		driver.findElement(By.id("second_date_picker")).click();
		Thread.sleep(2000);
		action.doubleClick(driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[contains(@class,'ui-datepicker-calendar')]//tr//td[not(contains(@class,' ui-datepicker-other-month'))]//a[text()="+day+"]")).click();

		//calender three
		Thread.sleep(3000);
		
		driver.findElement(By.id("third_date_picker")).click();
		Thread.sleep(2000);
		

	}

}
