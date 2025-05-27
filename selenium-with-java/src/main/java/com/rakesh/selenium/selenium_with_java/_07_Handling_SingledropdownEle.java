package com.rakesh.selenium.selenium_with_java;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class _07_Handling_SingledropdownEle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser opened");
		driver.manage().window().maximize();
		
		driver.get("https://omayo.blogspot.com/");
		String titleString = driver.getTitle();
		System.out.println("opened: " + titleString);
		
		/*
		 Dropdowns are two types in HTML:
		 *  1. Single dropdown: we can only select one option
		 *  2. Multi dropdown: we can select multiple options
		*/
		
		//When we create a Webelement it only identifies the dropdown element as an element
		WebElement selectElement = driver.findElement(By.id("drop1"));
		
		//After creating a Select objection and passing the WebElement object as a reference variable the selenium will understand that it is a dropdown element. and Select keyword is used to create a dropdown in HTML. 
		Select singleDropdown = new Select(selectElement);
		
		//Will print the first default selected option in the console
		String firstOption = singleDropdown.getFirstSelectedOption().getText();
		System.out.println("the first option was: " + firstOption);
		
		//Will print the all options of single dropdown element in the console
		List<WebElement> singleDropdownOptions = singleDropdown.getOptions();
		for (WebElement options : singleDropdownOptions) {
			System.out.println(options.getText());
		}
		
		//We can select the diffrent types of options of a select dropdown element by 3 methods
		
		//By using selectByIndex method
		singleDropdown.selectByIndex(2); //selects "doc2" option
		System.out.println("selected doc2");
		Thread.sleep(2000);
		
		//By using selectByValue methodH
		singleDropdown.selectByValue("jkl"); //selects "doc3" option
		System.out.println("selected doc3");
		Thread.sleep(2000);
		
		//By using selectByVisibleText method
		singleDropdown.selectByVisibleText("Older Newsletters"); //selects "Older Newsletters" option
		System.out.println("selected Older Newsletters");
		Thread.sleep(2000);
		
		System.out.println("browser is about to close");
		driver.quit();
	}

}
