package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalProject {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Setup ChromeDriver using WebDriverManager (no manual path needed)
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Browser launched and maximized");
    }

    @Test(priority = 1)
    public void openWebsite() {
        driver.get("https://www.letskodeit.com/practice");
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertTrue(title.contains("Practice"), "Title does not match expected value!");
    }

    @Test(priority = 2)
    public void textBoxAndAlertTest() throws InterruptedException {
        WebElement nameBox = driver.findElement(By.id("name"));
        nameBox.sendKeys("Shubham TestNG Automation");
        Thread.sleep(1000);

        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(1000);

        // Switch to alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert Text: " + alertText);

        driver.switchTo().alert().accept(); // Accept alert
    }

    @Test(priority = 3)
    public void radioAndCheckboxTest() throws InterruptedException {
        WebElement radioButton = driver.findElement(By.id("bmwradio"));
        radioButton.click();
        Thread.sleep(1000);

        WebElement checkBox = driver.findElement(By.id("benzcheck"));
        checkBox.click();
        Thread.sleep(1000);

        Assert.assertTrue(radioButton.isSelected(), "BMW Radio button not selected!");
        Assert.assertTrue(checkBox.isSelected(), "Benz Checkbox not selected!");
    }

    @Test(priority = 4)
    public void dropdownTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("carselect"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Honda");
        Thread.sleep(1000);

        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();
        System.out.println("Selected Car: " + selectedValue);
        Assert.assertEquals(selectedValue, "Honda", "Dropdown selection failed!");
    }

    @Test(priority = 5)
    public void multiSelectAndExtractText() throws InterruptedException {
        WebElement multipleSelect = driver.findElement(By.id("multiple-select-example"));
        Select multi = new Select(multipleSelect);
        multi.selectByValue("apple");
        multi.selectByValue("orange");
        Thread.sleep(1000);

        WebElement heading = driver.findElement(By.xpath("//legend[contains(text(),'Switch')]"));
        System.out.println("Extracted Heading Text: " + heading.getText());
        Assert.assertTrue(heading.isDisplayed(), "Heading not visible!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("✅ Test execution completed and browser closed.");
    }
}
