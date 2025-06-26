package com.rakesh.selenium.selenium_with_java;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class smth {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/shubh/selenium-profile");
//		options.addArguments("profile-directory=default");
		options.addArguments("--incognito");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignup%3Fref_cta%3DSign%2Bup%26ref_loc%3Dheader%2Blogged%2Bout%26ref_page%3D%252F%26source%3Dheader-home");
		
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//a[contains(@href, 'https://github.com/')]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//h1)[1]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//label[@for='login_field']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//input[@name='login' or @id='login_field']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//label[@for='password']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[1]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//span[text()])[10]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//p[@class='mt-1 mb-0 p-0']")), driver);
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//a[.='Create an account']")).click();
		
		highlight(driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/span")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/a")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.className("signup-form-fields__h2")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//label[@class='text-semibold'])[1]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//label[@class='text-semibold'])[2]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//label[@class='text-semibold'])[3]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[1]/child::*")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[2]/child::*")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[3]/child::*")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//label)[4]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//span[starts-with(@class,'Button-content Button-content--alignStart')]")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//legend[@class='text-semibold']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//input[@type='checkbox']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//label[@class='text-normal FormControl-label']")), driver);
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("(//span[@class='Button-content'])[1]")), driver);
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@name='login' or @id='login_field']")).sendKeys("edits000.11@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[1]")).sendKeys("github6302328162@");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")).click();
		
		Thread.sleep(2000);
		highlight(driver.findElement(By.xpath("//button[@id='dialog-show-dialog-aa2d464f-f76b-4055-8427-183ccb9f4ea6']")),driver);
		
		

	}
	public static void highlight(WebElement element, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:green')",element);
	}
}
