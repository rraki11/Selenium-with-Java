package com.rakesh.selenium.selenium_with_java;

// Import Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
@SuppressWarnings("unused") //will suppress the warnings when we didn't used the resource

public class Opening_a_browser {

    public static void main(String[] args) {
        
        // Create a new instance of ChromeDriver (opens Chrome browser)
        WebDriver driver = new ChromeDriver();
        
        // Navigate to Google and print its title
        driver.get("https://google.com/");
        String google = driver.getTitle();
        System.out.println("Opened: " + google);

        // Navigate to your GitHub repository and print its title
        driver.get("https://github.com/rraki11/Selenium-with-Java");
        String github = driver.getTitle();
        System.out.println("Opened: " + github);

        // Close the browser session
        driver.quit();

        /*
        Uncomment the following section to use Firefox instead of Chrome

        //Create a new instance of FirefoxDriver (opens Firefox browser)
        WebDriver driver = new FirefoxDriver();

        //Navigate to Google and print its title
        driver.get("https://google.com/");
        String title = driver.getTitle();
        System.out.println("The title from the Firefox browser is: " + title);

        //Close the browser
        driver.quit();
        */
    }
}