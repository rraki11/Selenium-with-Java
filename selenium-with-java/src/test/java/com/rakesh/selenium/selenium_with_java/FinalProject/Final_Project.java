package com.rakesh.selenium.selenium_with_java.FinalProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Final_Project {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static FileInputStream fi;
	private Actions action;
	public static JavascriptExecutor jsExecutor;
	private static final int PRODUCT_COLUMN_INDEX = 0;
	public String parentTab;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test(priority = 0)
	public void login() {
		action = new Actions(driver);

		By accountListLink = By.id("nav-link-accountList");
		WebElement accountListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountListLink));

		action.moveToElement(accountListElement).perform();

		By signInButton = By.cssSelector("#nav-flyout-ya-signin a");
		WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signInButton));

		signInElement.click();

		WebElement mobORemail = driver.findElement(By.xpath("//*[@id= \"ap_email_login\"]"));
		mobORemail.click();
		mobORemail.sendKeys("Podishettimanohar@gmail.com");
		WebElement pass = driver.findElement(By.className("a-button-input"));
		pass.click();

		driver.findElement(By.id("ap_password")).sendKeys("AMAZON017");
		driver.findElement(By.id("signInSubmit")).click();
	}

	@Test(priority = 1)
	public void ProductsByPropertiesfile() throws Exception {

		// Load test data
		fi = new FileInputStream(System.getProperty("user.dir") + "\\FinalProject\\items.properties");
		Properties prollist = new Properties();
		prollist.load(fi);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Search for first item
		WebElement search1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search1.click();
		search1.sendKeys(prollist.getProperty("item1"));
		search1.submit();

		// Waiting for results to load and click first product
		WebElement product1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-tall-aspect']")));
		product1.click();

		String parentTab = driver.getWindowHandle();

		// Switch to new tab and add product to cart
		AddToCart(parentTab);

		// Switch back to main window
		driver.switchTo().window(parentTab);

		// Search for second item
		WebElement search2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search2.click();
		search2.clear();
		Thread.sleep(2000);
		search2.sendKeys(prollist.getProperty("item2"));
		search2.submit();

		WebElement product2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product2.click();
		
		AddToCart(parentTab);
		driver.switchTo().window(parentTab);

		// Search for third item
		WebElement search3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search3.click();
		search3.clear();
		Thread.sleep(2000);
		search3.sendKeys(prollist.getProperty("item3"));
		search3.submit();

		WebElement product3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product3.click();

		AddToCart(parentTab);
		driver.switchTo().window(parentTab);

		// Search for fourth item
		WebElement search4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search4.click();
		search4.clear();
		Thread.sleep(2000);
		search4.sendKeys(prollist.getProperty("item4"));
		search4.submit();

		WebElement product4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product4.click();

		AddToCart(parentTab);
		driver.switchTo().window(parentTab);

		// Search for five item
		WebElement search5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search5.click();
		search5.clear();
		Thread.sleep(2000);
		search5.sendKeys(prollist.getProperty("item5"));
		search5.submit();

		WebElement product5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product5.click();

		AddToCart(parentTab);
		driver.switchTo().window(parentTab);

		// Search for six item
		WebElement search6 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search6.click();
		search6.clear();
		Thread.sleep(2000);
		search6.sendKeys(prollist.getProperty("item6"));
		search6.submit();

		WebElement product6 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product6.click();

		AddToCart(parentTab);
		driver.switchTo().window(parentTab);

		// Search for seven item
		WebElement search7 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search7.click();
		search7.clear();
		Thread.sleep(2000);
		search7.sendKeys(prollist.getProperty("item7"));
		search7.submit();
		
		WebElement product7 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product7.click();
		
		AddToCart(parentTab);
		Thread.sleep(1000);
		driver.switchTo().window(parentTab);

		// Search for eight item
		WebElement search8 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search8.click();
		search8.clear();
		Thread.sleep(2000);
		search8.sendKeys(prollist.getProperty("item8"));
		search8.submit();
		
		WebElement product8 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product8.click();
		
		AddToCart(parentTab);
		Thread.sleep(1000);
		driver.switchTo().window(parentTab);

		// Search for nine item
		WebElement search9 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search9.click();
		search9.clear();
		Thread.sleep(2000);
		search9.sendKeys(prollist.getProperty("item9"));
		search9.submit();
		
		WebElement product9 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product9.click();
		
		AddToCart(parentTab);
		Thread.sleep(1000);
		driver.switchTo().window(parentTab);

		// Search for ten item
		WebElement search10 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search10.click();
		search10.clear();
		Thread.sleep(2000);
		search10.sendKeys(prollist.getProperty("item10"));
		search10.submit();

		WebElement product10 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		product10.click();
		
		AddToCart(parentTab);
		Thread.sleep(1000);
		driver.switchTo().window(parentTab);
	}

	private static void AddToCart(String parentTab) throws InterruptedException {

		Set<String> allTabs = driver.getWindowHandles();

		for (String handle : allTabs) {
			if (!handle.equals(parentTab)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();

				WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement addToCartBtn = null;

				// 1. ATTEMPT 1
				try {

					addToCartBtn = Wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

				} catch (Exception e) {

					System.out.println("Attempt 1 failed");

					// 2. ATTEMPT 2
					try {

						addToCartBtn = Wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button\"]")));

					} catch (Exception ex) { // 3. ATTEMPT 3

						addToCartBtn = Wait.until(ExpectedConditions
								.elementToBeClickable(By.xpath("(//*[@id='add-to-cart-button'])[2]")));
					}

					// 4.ATTEPT 4
					try {

						addToCartBtn = Wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
								"//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")));
					} catch (Exception exe) {
						addToCartBtn = Wait.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//input[@id='add-to-cart-button' or @name='submit.add-to-cart']")));
					}
				}

				if (addToCartBtn != null) {
					addToCartBtn.click();
					System.out.println("✅ Product added to cart successfully.");
				} else {
					System.err.println("❌ Failed to find a clickable 'Add to Cart' button after all attempts.");
				}

				Thread.sleep(1000);

				driver.close();
			}
		}
	}
	
	@Test(priority = 3)
	public void SelectProdBySpecific() throws Exception {

		WebElement search = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		search.click();
		search.clear();
		Thread.sleep(2000);
		search.sendKeys("laptop");
		search.submit();
		Thread.sleep(2000);

		By dropdownLocator = By.xpath("//span[contains(text(), 'Sort by:')]");

		WebElement dropdownButton = driver.findElement(dropdownLocator);
		dropdownButton.click();

		Thread.sleep(1000);
		By optionLocator = By.xpath("//a[contains(text(), 'Price: High to Low')]");
		WebElement optionElement = driver.findElement(optionLocator);
		optionElement.click();

		Thread.sleep(2000);

		String hpXpath = "//*[@id=\"p_123/308445\"]/span/a/span";
		WebElement hpCheckbox = driver.findElement(By.xpath(hpXpath));

		if (!hpCheckbox.isSelected()) {
			hpCheckbox.click();
			System.out.println("Clicked HP filter.");
			Thread.sleep(2000);
		}

		String lenovoXpath = "//*[@id=\"p_123/219979\"]/span/a/div/label/i";

		WebElement lenovoCheckbox = driver.findElement(By.xpath(lenovoXpath));

		if (!lenovoCheckbox.isSelected()) {
			lenovoCheckbox.click();
			System.out.println("Clicked");

			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);

		String newxpath = "//*[@id=\"p_n_condition-type/8609960031\"]/span/a/span";
		WebElement NewCheckbox = driver.findElement(By.xpath(newxpath));

		if (!NewCheckbox.isSelected()) {
			NewCheckbox.click();
			System.out.println("Clicked");

			Thread.sleep(2000);
		}
		
		String sizeXpath = "//*[@id=\"p_n_g-1004162270091/2917528031\"]/span/a/span";
		WebElement sizeCheckbox = driver.findElement(By.xpath(sizeXpath));

		if (!sizeCheckbox.isSelected()) {
			sizeCheckbox.click();
			System.out.println("Clicked");

			Thread.sleep(2000);
		}
		
		WebElement productdrop = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1'] div[class='a-section aok-relative s-image-fixed-height']")));
		productdrop.click();
		AddToCart(parentTab);

		WebElement searchb = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
		searchb.click();
		searchb.clear();
		Thread.sleep(2000);
		driver.switchTo().window(parentTab);
		
	}

	@Test(priority = 4)
	public static void ReadingProductsDataFromExcelFile() throws Exception {

		String parentHandle = driver.getWindowHandle();
		try {
			String filePath = "C:\\Users\\shubh\\AppData\\Local\\Packages\\5319275A.WhatsAppDesktop_cv1g1gvanyjgm\\TempState\\78758E1A20A92614551DD56294223ADF\\readingdataforProucts.xlsx";

			FileInputStream file = new FileInputStream(filePath);

			try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
				XSSFSheet sheet = workbook.getSheet("Sheet1");
				if (sheet == null) {
					return;
				}

				int totalRows = sheet.getLastRowNum();

				for (int r = 1; r <= totalRows; r++) {
					XSSFRow currentRow = sheet.getRow(r);
					if (currentRow == null) {
						continue;
					}

					XSSFCell cell = currentRow.getCell(PRODUCT_COLUMN_INDEX);
					String productName = getCellValue(cell);

					if (productName.isEmpty()) {
						continue;
					}
					performSearchAndOpenProduct(productName, parentHandle);
				}

			} catch (IOException e) {
				System.err.println("file not readed");
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found");

		} catch (Exception e) {
			System.out.println("exception occured");
			e.printStackTrace();
		}
	}

	public static String getCellValue(XSSFCell cell) {
		if (cell == null) {
			return "";
		}

		try {
			return cell.getStringCellValue().trim();
		} catch (IllegalStateException e) {
			try {
				return String.valueOf((int) cell.getNumericCellValue()).trim();
			} catch (Exception numEx) {
				return "";
			}
		}
	}

	public static void performSearchAndOpenProduct(String productName, String parentHandle) throws Exception {
		try {

			WebElement searchBar = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#twotabsearchtextbox")));
			searchBar.clear();
			searchBar.sendKeys(productName);

			WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
			searchButton.click();

			System.out.println("Search successful. Clicking first product...");

			WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div")));
			productLink.click();

			String parentTab = driver.getWindowHandle();
			AddToCart(parentTab);

			Set<String> allHandles = driver.getWindowHandles();
			String childHandle = null;

			for (String handle : allHandles) {
				if (!handle.equals(parentHandle)) {
					childHandle = handle;
					break;
				}
			}

			if (childHandle != null) {
				driver.switchTo().window(childHandle);
				System.out.println("Switched to new tab: " + driver.getTitle());

				driver.close();
				driver.switchTo().window(parentHandle);
			} else {
				driver.switchTo().window(parentHandle);
			}

		} catch (Exception e) {
			driver.switchTo().window(parentHandle);
		}
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void products() throws Exception {

		driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]")).click();
		Thread.sleep(2000);

		WebElement UpdateLocation = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[1]/div[2]/span/a/div[2]/span[2]"));
		UpdateLocation.click();

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement AddressLink = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/span[2]/a ")));

		AddressLink.click();

		String xpathAddAddress = "/html/body/div[1]/div[1]/div/div[3]/div/div/a/div/div";
		WebElement AddAddressbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathAddAddress)));
		AddAddressbtn.click();

		String filePath = "C:\\Users\\shubh\\AppData\\Local\\Packages\\5319275A.WhatsAppDesktop_cv1g1gvanyjgm\\TempState\\737014B6A940E365341BAFB671377514\\READINGADDRESSFROMEXCEL.xlsx"; 

		FileInputStream file = new FileInputStream(filePath);

		try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			DataFormatter formatter = new DataFormatter();

			int totalRows = sheet.getLastRowNum();

			for (int r = 1; r <= totalRows; r++) {
				XSSFRow currentRow = sheet.getRow(r);
				if (currentRow == null) {
					continue;
				}
				
				// 1.FULL NAME
				XSSFCell fullNameCell = currentRow.getCell(0);

				String fullName = (fullNameCell != null) ? formatter.formatCellValue(fullNameCell).trim() : "";

				if (!fullName.isEmpty()) {
					String FULL_NAME_ID = "address-ui-widgets-enterAddressFullName";

					By fullNameLocator = By.id(FULL_NAME_ID);

					WebElement fullNameField = wait
							.until(ExpectedConditions.visibilityOfElementLocated(fullNameLocator));
					fullNameField.clear();
					fullNameField.sendKeys(fullName);
					Thread.sleep(1000);
				}
				
				// 2. MOBILE NUMBER
				XSSFCell mobileCell = currentRow.getCell(1);
				String mobileNumber = (mobileCell != null) ? formatter.formatCellValue(mobileCell).trim() : "";

				if (!mobileNumber.isEmpty()) {

					String MOBILE_ID = "address-ui-widgets-enterAddressPhoneNumber";

					By mobileLocator = By.id(MOBILE_ID);
					WebElement mobileField = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileLocator));
					mobileField.clear();
					mobileField.sendKeys(mobileNumber);
					Thread.sleep(1000);
				}

				// 3. PINCODE
				XSSFCell pincodeCell = currentRow.getCell(2);
				String pincode = (pincodeCell != null) ? formatter.formatCellValue(pincodeCell).trim() : "";

				if (!pincode.isEmpty()) {
					String PINCODE_ID = "address-ui-widgets-enterAddressPostalCode";

					By pincodeLocator = By.id(PINCODE_ID);
					WebElement pincodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(pincodeLocator));
					pincodeField.clear();
					pincodeField.sendKeys(pincode);
					Thread.sleep(1000);
				}
				
				// 4. FlatAddress
				XSSFCell FlatAddCell = currentRow.getCell(3);
				String FlatAdd = (FlatAddCell != null) ? formatter.formatCellValue(FlatAddCell).trim() : "";

				if (!FlatAdd.isEmpty()) {
					String FlatADD_ID = "address-ui-widgets-enterAddressLine1";

					By FlatAddLocator = By.id(FlatADD_ID);
					WebElement FlatAddField = wait.until(ExpectedConditions.visibilityOfElementLocated(FlatAddLocator));
					FlatAddField.clear();
					FlatAddField.sendKeys(FlatAdd);
					Thread.sleep(1000);
				}
				
				// 5.AreaAddresss

				XSSFCell AreaAddCell = currentRow.getCell(4);
				String AreaAdd = (AreaAddCell != null) ? formatter.formatCellValue(AreaAddCell).trim() : "";

				if (!AreaAdd.isEmpty()) {
					String AreaADD_ID = "address-ui-widgets-enterAddressLine2";

					By AreaAddLocator = By.id(AreaADD_ID);
					WebElement AreaAddField = wait.until(ExpectedConditions.visibilityOfElementLocated(AreaAddLocator));
					AreaAddField.clear();
					AreaAddField.sendKeys(AreaAdd);
					Thread.sleep(1000);
				}
				
				// 6.landmark
				XSSFCell LandmarkCell = currentRow.getCell(5);
				String Landmark = (LandmarkCell != null) ? formatter.formatCellValue(LandmarkCell).trim() : "";

				if (!Landmark.isEmpty()) {
					String Landmark_ID = "address-ui-widgets-landmark";

					By LandmarkLocator = By.id(Landmark_ID);
					WebElement Landmarkfield = wait
							.until(ExpectedConditions.visibilityOfElementLocated(LandmarkLocator));
					Landmarkfield.clear();
					Landmarkfield.sendKeys(Landmark);
					Thread.sleep(1000);
				}
				
				Thread.sleep(2000);

				WebElement AddAddress = driver
						.findElement(By.xpath("//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input"));
				AddAddress.click();
			}
		} catch (Exception e) {
			System.err.println("An error occurred during data processing: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Test(priority = 6)
	public static void GOADDTOCART() throws Exception {

		Thread.sleep(3000);

		WebElement gotocart = driver
				.findElement(By.xpath("//*[@id='ewc-compact-actions-container']/div/div[2]/span/span/a"));
		gotocart.click();

		WebElement ProcedToBuybtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[1]/div[1]/div[4]/div[5]/div/div[1]/div[1]/div/form/div/div[3]/span[1]/span/span/input")));
		ProcedToBuybtn.click();

		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./finalproject_screenshot/img.jpg");
		FileUtils.copyFile(sourcefile, destfile);

		System.out.println("screenshot saved successfully");

	}

}