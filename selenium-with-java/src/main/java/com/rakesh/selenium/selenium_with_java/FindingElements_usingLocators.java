package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElements_usingLocators {
    public static void main(String[] args) throws InterruptedException {

        // InterruptedException is used when we use Thread.sleep(), 
        // which pauses the execution for a certain time (in milliseconds)

        // Locators help Selenium WebDriver identify elements on the web page
        // There are 8 types of locators: id, name, className, tagName, linkText, 
        // partialLinkText, cssSelector, xpath

        WebDriver driver = new ChromeDriver(); // Launches the Chrome browser
        driver.get("https://omayo.blogspot.com/2013/05/page-one.html"); // Opens the target URL

        Thread.sleep(3000); // Wait for 3 seconds

        // Locate an element using ID
        highlight(driver, driver.findElement(By.id("ta1")));
        Thread.sleep(3000);

        // Locate an element using Name
        highlight(driver, driver.findElement(By.name("form1")));
        Thread.sleep(3000);

        // Locate a link using exact link text (Only works for <a> tags)
        highlight(driver, driver.findElement(By.linkText("Selenium143")));
        Thread.sleep(3000);

        // Locate a link using partial link text, instead of "seleniumTutorial" we only typed "SeleniumTuto" 		which is called as the partial text of the original text.. (Only works for <a> tags)
        highlight(driver, driver.findElement(By.partialLinkText("SeleniumTuto")));
        Thread.sleep(3000);

        // Locate an element using class name (only one class should be passed if using className locator)
        highlight(driver, driver.findElement(By.className("date-header")));
        Thread.sleep(3000);

        // Locate an element using tag name (note: multiple <h2> elements exist, only the first one will be 		highlighted)
        highlight(driver, driver.findElement(By.tagName("h2")));
        Thread.sleep(3000);

        // Locate an element using CSS selector
        highlight(driver, driver.findElement(By.cssSelector("input[id='alert1']")));
        Thread.sleep(3000);

        // Quit the browser after completing the actions
        driver.quit();
    }

    /**
     * This method highlights the located element by applying a border and background color
     * @param driver - WebDriver instance
     * @param element - WebElement to highlight
     */
    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll the element into view and apply a red border with a light background
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; background: lightyellow;')", element);
    }
}
