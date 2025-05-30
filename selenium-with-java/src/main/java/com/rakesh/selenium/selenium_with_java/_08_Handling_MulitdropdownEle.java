package com.rakesh.selenium.selenium_with_java;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _08_Handling_MulitdropdownEle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";
		ChromeOptions options = new ChromeOptions();
		options.setBinary(bravePath);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		System.out.println("Brave opened: " + driver.getTitle());
		
		Thread.sleep(2000);
		WebElement multidropdown = driver.findElement(By.id("multiselect1"));
		
		Select Multidropdown = new Select(multidropdown);
		
//it dosent have any first option like it was in single drop down element
//so, we cant use "Multidropdown.getFirstSelectedOptions().getText();" like we did with single dropdown element to print/get the first selected option
		
		//but we can print the first option like this
		List<WebElement> selected = Multidropdown.getAllSelectedOptions();
		if (!selected.isEmpty()) {
		    System.out.println("First selected: " + selected.get(0).getText());
		} else {
		    System.out.println("No options selected yet.");
		}
		
		//Prints all the options present in the Multidropdown element
		List<WebElement> MultidropOptons = Multidropdown.getOptions();
		for (WebElement dropDownoptions : MultidropOptons) {
			System.out.println(dropDownoptions.getText());
		}

		//Selecting multiple options using different options
		Multidropdown.selectByIndex(0); //selects "Volvo"
		Thread.sleep(2000);
		Multidropdown.selectByValue("swiftx"); //selects "Swift"
		Thread.sleep(2000);
		Multidropdown.selectByVisibleText("Audi"); //selects "Audi"
		Thread.sleep(2000);
		
		//we can also deselect the options in Multidropdown 
		//but we cant deselec the options in Singledropdown
		Multidropdown.deselectByIndex(1); //deselects "Swift"
		Thread.sleep(2000);
		
		//we can also print/get the selected options
		List<WebElement> selectedOpt = Multidropdown.getAllSelectedOptions();
		System.out.println("selected options are: ");
		for (WebElement selectedoptions : selectedOpt) {
			System.out.println(selectedoptions.getText());
		}
		
		
		System.out.println("brave is about to close");
		Thread.sleep(1000);
		driver.quit();
		
	}

}
