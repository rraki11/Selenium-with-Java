package com.rakesh.selenium.selenium_with_java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _26_DesiredCapabilites {

	public static void main(String[] args)throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setAcceptInsecureCerts(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.merge(dcaps);
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://www.cacert.org/");
		
		System.out.println("unsecured website accessed");
		Thread.sleep(3000);
		
		driver.quit();
	}

}
