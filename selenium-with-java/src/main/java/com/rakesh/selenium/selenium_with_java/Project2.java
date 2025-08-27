package com.rakesh.selenium.selenium_with_java;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project2 {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + System.getProperty("user.dir") + "/selenium-profile");
        options.addArguments("profile-directory=default");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        deletesc(); // clear old screenshots
        
        driver.get("https://www.amazon.com/ref=nav_logo");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
        
        // Wait for the "Add to Cart" button to be clicked manually by you
        WebElement addedToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
        	    By.xpath("//*[contains(text(),'Added to cart')]") 
        	    //searches for all tags to find "added to cart" text
        	));

        // Take screenshot after successful Add to Cart
        String y = "./Screenshots/project2_addtocart.jpg";
        screenshot(driver, y);

        driver.quit();
    }
    
    public static void screenshot(WebDriver x, String y) throws IOException {
        TakesScreenshot tScreenshot = (TakesScreenshot) x;
        File srcFile = tScreenshot.getScreenshotAs(OutputType.FILE);
        File dstFile = new File(y);

        FileUtils.copyFile(srcFile, dstFile);
        System.out.println("screenshot saved at: " + dstFile.getAbsolutePath());
    }

    public static void deletesc() {
        File locationFile = new File ("./Screenshots");
        
        if (locationFile.exists() && locationFile.isDirectory()) {
            for (File folders : locationFile.listFiles()) {
                folders.delete();
            }
            System.out.println("Previous screenshots deleted.");
        } else {
            System.out.println("No existing screenshots folder found.");
        }
    }
}
