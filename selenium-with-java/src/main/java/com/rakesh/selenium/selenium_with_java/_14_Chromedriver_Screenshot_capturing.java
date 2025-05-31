package com.rakesh.selenium.selenium_with_java;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _14_Chromedriver_Screenshot_capturing {

    public static void main(String[] args) throws IOException {

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Launch a new Chrome browser instance
        ChromeDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google's homepage
        driver.get("https://google.com/");

        // Delete existing screenshots before taking new ones
        DeleteScreenshot();

        // ---------------- Screenshot using FILE format ----------------
        // Takes a screenshot and stores it as a File object
        File srcFile1 = driver.getScreenshotAs(OutputType.FILE);
        File desntFile1 = new File("./Screenshots/fileimg.jpg"); // Destination file
        FileUtils.copyFile(srcFile1, desntFile1); // Copy screenshot to destination
        System.out.println("Screenshot taken through FILES saved in \"Screenshot folder\" Successfully");

        // ---------------- Screenshot using BYTES format ----------------
        // Takes a screenshot and stores it as a byte array
        byte srcFile2[] = driver.getScreenshotAs(OutputType.BYTES);
        File desntFile2 = new File("./Screenshots/byteimg.jpg"); // Destination file
        FileOutputStream fos = new FileOutputStream(desntFile2); // Create output stream
        fos.write(srcFile2); // Write bytes to file
        fos.close(); // Close output stream
        System.out.println("Screenshot taken through BYTES saved in \"Screenshot folder\" Successfully");

        // ---------------- Screenshot using BASE64 format ----------------
        // Takes a screenshot and stores it as a BASE64 encoded string
        String srcFile3 = driver.getScreenshotAs(OutputType.BASE64);
        byte srcFileArray[] = Base64.getDecoder().decode(srcFile3); // Decode BASE64 to byte array
        File desntFile3 = new File("./Screenshots/base64.jpg"); // Destination file
        FileOutputStream fos2 = new FileOutputStream(desntFile3); // Create output stream
        fos2.write(srcFileArray); // Write bytes to file
        fos2.close(); // Close output stream
        System.out.println("Screenshot taken through BASE64 saved in \"Screenshot folder\" Successfully");

        // Close the browser
        driver.quit();
    }

    // Method to delete all files in the Screenshots folder before saving new ones
    public static void DeleteScreenshot() {
        File screenshotFile = new File("./Screenshots");
        if (screenshotFile.exists() && screenshotFile.isDirectory()) {
            for (File files : screenshotFile.listFiles()) {
                files.delete(); // Delete each file
            }
        }
    }

}