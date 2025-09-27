package com.rakesh.selenium.selenium_with_java;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _31_using_excel_util_ {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		
		try {
		    WebElement acceptBtn = driver.findElement(By.id("onetrust-accept-btn-handler"));
		    acceptBtn.click();
		    System.out.println("Cookie banner closed.");
		} catch (Exception e) {
		    System.out.println("No cookie banner found.");
		}

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0,350);");
		
		String flocation="C:\\Users\\shubh\\Documents\\sel util excel p-4.xlsx";
		
int rows = ExcelUtil.getRows(flocation, "Sheet1");
		
		for(int r=1;r<=rows;r++) {
			
			//reading data from excel file
			String ida=ExcelUtil.getCellData(flocation, "Sheet1", r, 0);
			String lenofcd=ExcelUtil.getCellData(flocation, "Sheet1", r, 1);
			String rate=ExcelUtil.getCellData(flocation, "Sheet1", r, 2);
//			String compounding=ExcelUtil.getCellData(flocation, "Sheet1", r, 3);
			String expectedres=ExcelUtil.getCellData(flocation, "Sheet1", r, 4);
			
			
			WebElement initdepAmount = driver.findElement(By.xpath("//*[@id='mat-input-0']"));
			WebElement lenofCD = driver.findElement(By.xpath("//*[@id='mat-input-1']"));
			WebElement iofRate = driver.findElement(By.xpath("//*[@id='mat-input-2']"));
			WebElement letsrun = driver.findElement(By.xpath("//*[@id='CIT-chart-submit']"));
			WebElement totalvalue = driver.findElement(By.xpath("//*[@id='validResults']//span[4]"));
			
			//clearing the previous data of browser and entering new data
			initdepAmount.click();
			initdepAmount.clear();
			initdepAmount.sendKeys(ida);
			
			lenofCD.click();
			lenofCD.clear();
			lenofCD.sendKeys(lenofcd);
			
			iofRate.click();
			iofRate.clear();
			iofRate.click();
			iofRate.sendKeys(rate);
//			iofRate.sendKeys(String.valueOf(rate));
			
			driver.findElement(By.xpath("//*[@id='mat-select-value-1']")).click(); //selecting dropdown
			driver.findElement(By.xpath("//*[@id=\"mat-option-4\"]")).click();
			
			letsrun.click();
			
			//validating and writing date into excel
			if(totalvalue.getText().equals(expectedres)) {
				System.out.println("expected data correct");
				ExcelUtil.setCellData(flocation, "Sheet1", r, 5, "valid");
			}else { 
				System.out.println("expected data not correct");
				ExcelUtil.setCellData(flocation, "Sheet1", r, 5, totalvalue.getText());	} 
		}
		
		driver.quit();
		
	}

}
