package com.rakesh.selenium.selenium_with_java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _18_ExplicitWait_builtINclass {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Create an Explicit Wait object
        // Parameters:
        // 1. driver - the WebDriver instance
        // 2. 10 seconds - max time to wait for the condition
        // 3. 500 milliseconds - polling(gap) interval (how often to check the condition)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));

        driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
        
        driver.findElement(By.id("btn1")).click();

        // Use "visibilityOfElementLocated" when:
        // - The element might not yet be present in the DOM (common for dynamically loaded content)
        // - And you're waiting for it to be visible on the screen

        // Wait until the element with id 'txt1' is present in the DOM and visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1")));
        driver.findElement(By.id("txt1")).sendKeys("Hi Hlo mick testing 1 2 3");
        
        Thread.sleep(3000);
        driver.quit();
    }
}