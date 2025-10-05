package com.rakesh.selenium.selenium_with_java;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class creating_acc_using_excelFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.ulta.com/");

		try {
		    WebElement acceptBtn = driver.findElement(By.id("onetrust-accept-btn-handler"));
		    acceptBtn.click();
		    System.out.println("Cookie banner closed.");
		} catch (Exception e) {
		    System.out.println("No cookie banner found.");
		}
		
		String flocation = "C:\\Users\\shubh\\Documents\\create_acc.xlsx"; 
		
		int rowCount = ExcelUtil.getRows(flocation, "Sheet1");
		System.out.println("Total rows found = " + rowCount);

		
		WebElement login_but = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/header/div[2]/div/div/div/div[2]/ul/li[2]/div/div[1]/a/span"));
		login_but.click();
		
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,150);");
		
	
		WebElement create_acc = driver.findElement(By.xpath("/html/body/div[1]/div/main/section/div/div/div/div[2]/p/a"));
		create_acc.click();
		
		
		
		for(int r=1; r<=rowCount;r++) {	//igonred the first row due to headings
			
			//reading data from excel file
			String Fname=ExcelUtil.getCellData(flocation, "Sheet1", r, 0);
			String Lname=ExcelUtil.getCellData(flocation, "Sheet1", r, 1);
			String MobNum=ExcelUtil.getCellData(flocation, "Sheet1", r, 2);
			String email=ExcelUtil.getCellData(flocation, "Sheet1", r, 3);
			String pass=ExcelUtil.getCellData(flocation, "Sheet1", r, 4);
			String state=ExcelUtil.getCellData(flocation, "Sheet1", r, 5);
			
			//webelements of site
			WebElement fName=driver.findElement(By.xpath("//*[@id='firstName']")); //first name
			WebElement lName=driver.findElement(By.xpath("//*[@id='lastName']")); //last name
			WebElement mobnum=driver.findElement(By.xpath("//*[@id='phoneNumber']")); //phone number
			WebElement Email=driver.findElement(By.xpath("//*[@id='email']")); //email
			WebElement Pass=driver.findElement(By.xpath("//*[@id='password']")); //passoword
			WebElement dpElement = driver.findElement(By.xpath("//*[@id='province']")); //dropdown
			Select dropdownSelect = new Select(dpElement);
			
			//writing in webelements
			fName.sendKeys(Fname);
			Thread.sleep(3000);
			lName.click();
			lName.sendKeys(Lname);
			Thread.sleep(3000);
			mobnum.click();
			mobnum.sendKeys(MobNum);
			Thread.sleep(3000);
			Email.click();
			Email.sendKeys(email);
			Thread.sleep(3000);
			Pass.click();
			Pass.sendKeys(pass);
			Thread.sleep(3000);
			dropdownSelect.selectByVisibleText(state);

			
		}
		
		driver.findElement(By.xpath("//*[@id=\"ulp-container-form-content-end\"]/div[3]/label")).click(); //deselect
		
		driver.findElement(By.xpath("//*[@id=\"ulp-container-form-content-end\"]/div[6]/label")).click(); //deselect
		
		driver.findElement(By.xpath("/html/body/div[1]/div/main/section/div/div/div/form/div[5]")).click(); //clicking on sign in option
		
		
	}
	
}
