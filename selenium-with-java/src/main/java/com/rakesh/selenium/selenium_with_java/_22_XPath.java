package com.rakesh.selenium.selenium_with_java;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _22_XPath {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/shubh/selenium-profile");
		options.addArguments("profile-directory=Default");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		TypesOfXPath(driver);
		Thread.sleep(100 + new Random().nextInt(150));
		XPath_using_Attributes(driver);
		Thread.sleep(100 + new Random().nextInt(150));
		XPath_Operators(driver);
		Thread.sleep(100 + new Random().nextInt(150));
		XPath_Conditions(driver);
		Thread.sleep(100 + new Random().nextInt(150));
		XPath_with_Index(driver);
		Thread.sleep(100 + new Random().nextInt(150));
		XPath_Functions(driver);
		
		Thread.sleep(3000);
		driver.quit();
		
	}
//-----------------------------------------------------------------------------------------------------	
	public static void highlight(WebElement element, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:green')", element);
	}
//-----------------------------------------------------------------------------------------------------	
	public static void TypesOfXPath (WebDriver d) throws InterruptedException {
		d.get("https://www.youtube.com/");
		
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

	} 
//-----------------------------------------------------------------------------------------------------	
	public static void XPath_using_Attributes (WebDriver d) {
		d.get("https://www.amazon.com/");
		d.manage().window().maximize();
		
		// Finding the element by uisng "id" attribute
		WebElement ele1 = d.findElement(By.xpath("//div[@id='glow-ingress-block']"));
		highlight(ele1, d);
		
		WebElement ele2 = d.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
		highlight(ele2, d);
		
	}
//-----------------------------------------------------------------------------------------------------	
	public static void XPath_Operators (WebDriver d) {
		d.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		d.manage().window().maximize();
		
		// We can find the elements by using operators "(<,>,<=,>=,=,!=)"
		
		WebElement ele1 = d.findElement(By.xpath("//input[@maxlength = 10]"));
		highlight(ele1, d);
		
		WebElement ele2 = d.findElement(By.xpath("//input[@maxlength != 10]"));
		highlight(ele2, d);
		
//		d.findElement(By.xpath("//input[@maxlength > '10']"));
//		d.findElement(By.xpath("//input[@maxlength = '15']"));
//		d.findElement(By.xpath("//input[@maxlength >= '10']"));
//		
		// We use "findElements" when the elements are more than one to get identified
//		d.findElements(By.xpath("//input[@maxlength <= '15']"));
		List<WebElement> WEBelements = d.findElements(By.xpath("//input[@maxlength <= '15']"));
		for (WebElement WEBele : WEBelements) {
			highlight(WEBele, d);
		}
	}
//-----------------------------------------------------------------------------------------------------
	public static void  XPath_Conditions (WebDriver d) {
		d.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		// Returns the element when all of the conditons gets true if we use "and"
		WebElement ele1 = d.findElement(By.xpath("//h1[@class='post-title entry-title' and @itemprop='name']"));
		highlight(ele1, d);
		
		// Returns the element when one of the conditons gets true if we use "or"
		WebElement ele2 = d.findElement(By.xpath("//div[@ style='text-align: center;' or @class='this is not their']"));
		highlight(ele2, d);
		
		// "not" condition
		List<WebElement> webele = d.findElements(By.xpath("//input[not(@maxlength='10')]"));
		System.out.println("number of elements using \"not\" condtion "+ webele.size());
	}
//-----------------------------------------------------------------------------------------------------	
	public static void XPath_with_Index (WebDriver d) {
		d.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		
		// Using indexes in XPath. highlights the every row's 2nd table data
		List<WebElement> webelements = d.findElements(By.xpath("//table[@id='contactList']/tbody/tr/td[2]"));
		for (WebElement webElement : webelements) {
			highlight(webElement, d);
		}
		
		// Highlights the single table data of any specific row
		WebElement ele1 = d.findElement(By.xpath("//table[@id='contactList']/tbody/tr[4]/td[4]"));
		highlight(ele1, d);
		
		// Highlights the single table data by using its postional number
		WebElement ele2 = d.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[29]"));
		highlight(ele2, d);
	}
//-----------------------------------------------------------------------------------------------------
	public static void XPath_Functions (WebDriver d) {
		// There are 6 types of Functions:
		// Text, Contains, Starts-with, Normalize-space, Last, Position
		
// Text function
		 //complete text
		WebElement ele1 = d.findElement(By.xpath("//a[text()='Sign in into account']"));
		highlight(ele1, d);
		 //partial text
		d.findElement(By.xpath("//a[contains(text(),'into account')]"));
		
// Contains function
		//contains() is mainly used for partial text or partial attribute value matching
		WebElement ele2 = d.findElement(By.xpath("//button[contains(@class,'btn')]"));
		highlight(ele2, d);
		WebElement ele3 = d.findElement(By.xpath("//div[contains(@class,'container signin')]"));
		highlight(ele3, d);
		
// Starts-with function
		// starts-with() is used to check if text or attribute value begins with a specific string
		WebElement ele4 = d.findElement(By.xpath("//div[starts-with(@id,'sidebar-wrapper')]"));
		highlight(ele4, d);
		
// Normalize-space function
		// The normalize-space() function is used to remove leading and ending/trailing white spaces,
		// and to replace multiple spaces within the text with a single space.
		WebElement ele5 = d.findElement(By.xpath("//label[normalize-space(text())='First Name']"));
		highlight(ele5, d);
		
// Last function
		// last() returns the last element from the matched node list
		WebElement ele6 = d.findElement(By.xpath("(//table[@id='contactList']/tbody/tr/td)[last()]"));
		highlight(ele6, d);
		
// Postion function
		// position() gives the index of the current node, and supports operators like <, >, =, !=
		List<WebElement> ele7 = d.findElements(By.xpath("(//table[@id='contactList']/tbody/tr/td)[position()>1]"));
		System.out.println("number of elements less than 1st row: " + ele7.size());
	}
//-----------------------------------------------------------------------------------------------------
	
}
