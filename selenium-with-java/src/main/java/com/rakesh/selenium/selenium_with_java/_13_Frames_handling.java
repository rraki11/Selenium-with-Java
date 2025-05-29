package com.rakesh.selenium.selenium_with_java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _13_Frames_handling {
    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Open the practice page for frames
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
        // Interact with the text input field in the main (default) frame
        driver.findElement(By.id("name")).sendKeys("Rakesh");
        
        // 🔄 Switch from the default content to the first child frame (frm1)
        driver.switchTo().frame("frm1");
        Thread.sleep(3000);
        
        // Interact with the dropdown inside frame1
        Select coursedropdown = new Select(driver.findElement(By.id("course")));
        Thread.sleep(2500);
        coursedropdown.selectByVisibleText("Java");
        
        // 🔙 Switch back to the main (default) content from frame1
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        
        // Clear the previous text and re-enter a new name
        driver.findElement(By.id("name")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("name")).sendKeys("Shubham");
        
        // 🔄 Switch to second child frame (frm2) to interact with form fields
        driver.switchTo().frame("frm2");
        Thread.sleep(3000);
        
        // Fill in first name and last name fields inside frame2
        driver.findElement(By.id("firstName")).sendKeys("Shubham");
        Thread.sleep(3000);
        driver.findElement(By.id("lastName")).sendKeys("Routray");
        Thread.sleep(3000);
        
        // Select checkboxes for known languages
        driver.findElement(By.id("englishchbx")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("hindichbx")).click();
        Thread.sleep(3000);
        
        // Close the browser session
        driver.quit();
    }
}
