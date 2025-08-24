package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _24_Calender_practice {

	public static void main(String[] args)throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		
		int date1 = 23;
		int date2 = 30;
		
		// calender type 1
		WebElement picker1 = driver.findElement(By.id("first_date_picker"));
		picker1.click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()="+date1+"]")).click();
//		String pickervalue1 = picker1.getAttribute("value");
		String pickervalue1 = picker1.getDomProperty("value");
		System.out.println("calender 1: " + pickervalue1);
		
		// calender type 2
		WebElement picker2 =  driver.findElement(By.id("second_date_picker"));
		picker2.click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td[not(contains(@class,' ui-datepicker-other-month'))]/a[text()="+date2+"]")).click();
		String pickervalue2 = picker2.getDomProperty("value");
		System.out.println("calender 2: " + pickervalue2);
		
		
	}

}
