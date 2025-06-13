package com.rakesh.selenium.selenium_with_java;

import java.util.Arrays;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Project1 {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/shubh/selenium-profile");
		options.addArguments("profile-directory=default");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		Thread.sleep(100 + new Random().nextInt(150));	
		driver.get("https://www.amazon.com/");
			element1(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element2(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element3(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element4(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element5(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element6(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			driver.get("https://www.flipkart.com/");
			element7(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			driver.get("https://github.com/");
			element8(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element9(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			driver.get("https://www.google.com/");
			element10(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element111213141516(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
		driver.get("https://www.amazon.com/");
			element17(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
			element18(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
		driver.get("https://www.facebook.com/");
			element192021(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
		driver.get("https://www.youtube.com/");
			element22232425(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
		driver.get("https://gemini.google.com/app");
			element2627282930(driver);
			Thread.sleep(2000);
		Thread.sleep(100 + new Random().nextInt(150));
		driver.get("https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fsignup%3Fref_cta%3DSign%2Bup%26ref_loc%3Dheader%2Blogged%2Bout%26ref_page%3D%252F%26source%3Dheader-home");
			github(driver);
			
		Thread.sleep(3000);
		driver.quit();
		
	}
	
//---------------------------------------------------------------------------------------------------//	
		public static void highlight(WebElement element, WebDriver driver) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:green')", element);
		}
//---------------------------------------------------------------------------------------------------//	
	
	public static void element1 (WebDriver d ) {
		WebElement ele1 = d.findElement(By.id("nav-logo-sprites"));
		highlight(ele1, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element2 (WebDriver d) {
		WebElement ele2 = d.findElement(By.xpath
								("//div[starts-with(@class,'nav-sprite nav-progressive-attribute')]"));
		highlight(ele2, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element3 (WebDriver d) {
		WebElement ele3 = d.findElement(By.xpath("//div[@id='nav-search']"));
		highlight(ele3, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element4 (WebDriver d) {
		WebElement ele4 = d.findElement(By.xpath
										("//div[contains(@class,'nav-div') and @id='icp-nav-flyout']"));
		highlight(ele4, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element5 (WebDriver d) {
		WebElement ele5 = d.findElement(By.xpath("//h2[text()='Get your game on']"));
		highlight(ele5, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element6 (WebDriver d) {
		WebElement ele6 = d.findElement(By.className("navFooterBackToTopText"));
		highlight(ele6, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element7 (WebDriver d) {
		WebElement ele7 = d.findElement
							(By.xpath("/html/body/div/div/div/div/div/div/div/div/div/div/div/div/div/header/div/div/a/picture/img"));
		highlight(ele7, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element8 (WebDriver d) {
		WebElement ele8 = d.findElement(By.linkText("Sign up"));
		highlight(ele8, d);
	}
//---------------------------------------------------------------------------------------------------//
		
	public static void element9 (WebDriver d) {
		WebElement ele9 = d.findElement(By.partialLinkText("in"));
		highlight(ele9, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element10 (WebDriver d) {
		WebElement ele10 = d.findElement(By.name("q"));
		highlight(ele10, d);
	}	
//---------------------------------------------------------------------------------------------------//
	
	public static void element111213141516 (WebDriver d) {
		WebElement ele11 = d.findElement(By.xpath("//a[@class='MV3Tnb' and text()='About']"));
		highlight(ele11, d);
		WebElement ele12 = d.findElement(By.xpath("//a[@class='MV3Tnb' and text()='Store']"));
		highlight(ele12, d);
		WebElement ele13 = d.findElement(By.xpath("//a[@class='gb_X' and text()='Gmail']"));
		highlight(ele13, d);
		WebElement ele14 = d.findElement(By.xpath("//a[@class='gb_X' and text()='Images']"));
		highlight(ele14, d);
		WebElement ele15 = d.findElement(By.xpath("//a[@class='gb_B']"));
		highlight(ele15, d);
		WebElement ele16 = d.findElement(By.xpath("//a[@class='gb_A']"));
		highlight(ele16, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element17 (WebDriver d) {
		WebElement ele17 = d.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		ele17.click();
		highlight(ele17, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element18 (WebDriver d) throws InterruptedException {
		WebElement ele18 = d.findElement(By.xpath("//button[@aria-label='Expand to Change Language or Country' and @tabindex=0]"));
		ele18.click();
		highlight(ele18, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element192021 (WebDriver d) {
		WebElement ele19 = d.findElement(By.id("email"));
		highlight(ele19, d);
		WebElement ele20 = d.findElement(By.id("passContainer"));
		highlight(ele20, d);
//		WebElement ele21 = d.findElement(By.id("u_0_5_So"));
//		highlight(ele21, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element22232425 (WebDriver d) {
		WebElement ele22 = d.findElement(By.id("logo-icon"));
		highlight(ele22, d);
		WebElement ele23 = d.findElement(By.xpath("//input[@name='search_query']"));
		highlight(ele23, d);
		WebElement ele24 = d.findElement(By.xpath("//button[starts-with(@class,'ytSearchboxComponentSearchButton')]"));
		highlight(ele24, d);
		WebElement ele25 = d.findElement(By.xpath("//ytd-mini-guide-renderer"));
		highlight(ele25, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void element2627282930 (WebDriver d) {
		WebElement ele26 = d.findElement(By.xpath("//div[@data-test-id='logo']"));
		highlight(ele26, d);
		WebElement ele27 = d.findElement(By.xpath("//mat-icon[@role='img' and @fonticon='menu']"));
		highlight(ele27, d);
		WebElement ele28 = d.findElement(By.xpath("//mat-icon[@role='img' and @fonticon='add_2']"));
		highlight(ele28, d);
		WebElement ele29 = d.findElement(By.xpath("//div[@class='ql-editor ql-blank textarea new-input-ui' and @role='textbox']"));
		highlight(ele29, d);
		WebElement ele30 = d.findElement(By.xpath("//mat-icon[@fonticon='mic']"));
		highlight(ele30, d);
	}
//---------------------------------------------------------------------------------------------------//
	
	public static void github (WebDriver d) throws InterruptedException {
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//a[contains(@href, 'https://github.com/')]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//h1)[1]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//label[@for='login_field']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//input[@name='login' or @id='login_field']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//label[@for='password']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[1]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//*[@id=\"login\"]/div[4]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//span[text()])[10]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//p[@class='mt-1 mb-0 p-0']")), d);
		Thread.sleep(2000);
		
		d.navigate().refresh();
		
		d.findElement(By.xpath("//a[.='Create an account']")).click();
		
		highlight(d.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/span")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div/a")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.className("signup-form-fields__h2")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//label[@class='text-semibold'])[1]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//label[@class='text-semibold'])[2]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//label[@class='text-semibold'])[3]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[1]/child::*")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[2]/child::*")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//div[@class='mb-3 mt-1'])[3]/child::*")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//label)[4]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//span[starts-with(@class,'Button-content Button-content--alignStart')]")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//legend[@class='text-semibold']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//input[@type='checkbox']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("//label[@class='text-normal FormControl-label']")), d);
		Thread.sleep(2000);
		highlight(d.findElement(By.xpath("(//span[@class='Button-content'])[1]")), d);
		Thread.sleep(2000);
		
		d.navigate().back();
		
		d.findElement(By.xpath("//input[@name='login' or @id='login_field']")).sendKeys("edits000.11@gmail.com");
		Thread.sleep(2000);
		d.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[1]")).sendKeys("github6302328162@");
		d.findElement(By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]")).click();
	}
}
