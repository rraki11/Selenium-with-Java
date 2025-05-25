package com.rakesh.selenium.selenium_with_java;

// Import Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
@SuppressWarnings("unused") //will suppress the warnings when we didn't use the resource

public class _02_Opening_a_browser {

    public static void main(String[] args) {
        
    	//opening chrome browser
        // Create a new instance of ChromeDriver (opens Chrome browser)
        WebDriver driver = new ChromeDriver();
        
        // Navigate to Google and print its title
        driver.get("https://google.com/");
        String google = driver.getTitle();
        System.out.println("Opened: " + google);

        // Navigate to your GitHub repository and print its title
        driver.get("https://github.com/rraki11/Selenium-with-Java");
        String github = driver.getTitle();
        System.out.println("Chrome Opened: " + github);

        // Close the browser session
        driver.quit();
// ---------------------------------------------------------------------------------------------------------------------------------//
        //opening brave browser
        
        //set the brave path
        String bravePath = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe";

        //set the ChromeOptions to use brave
        //Here, you're telling Selenium to launch Brave instead of Chrome by setting Brave's path as the binary that ChromeDriver should use.
        ChromeOptions options = new ChromeOptions();
        //Now, Selenium uses ChromeDriver but because of the options.setBinary(bravePath) line, it launches Brave browser instead of Chrome.
        options.setBinary(bravePath);


        //use ChromeDriver with brave's binary
        WebDriver driver2 = new ChromeDriver(options);
        driver2.get("https://google.com/");
        System.out.println("Brave Opened: " + driver2.getTitle());
        
        //closing the browser session
        driver2.quit();


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