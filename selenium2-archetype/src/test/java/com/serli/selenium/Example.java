package com.serli.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Example {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	
	
	
	
	
	
	@Before
	public void setUp() throws Exception {
	    
	    // retrieve an environment variable
	    String variable = System.getProperty("The name of the variable");
	    
	    //driver chrome
	    System.setProperty("webdriver.chrome.driver", 
	            "C:\\formations\\selenium\\Selenium 2\\chromedriver.exe");
	    driver = new ChromeDriver();
        
	    //driver internet explorer
	    System.setProperty("webdriver.ie.driver", 
	            "C:\\formations\\selenium\\Selenium 2\\IEDriverServer.exe");
	    driver = new InternetExplorerDriver();
	    
	    //driver Firefox
	    driver = new FirefoxDriver();
	    
	    ExpectedConditions.alertIsPresent();

		baseUrl = "http://localhost:9000";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testExample() throws Exception {
		driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.id("signin")).click();
		driver.findElement(By.linkText("Add")).click();
		driver.findElement(By.id("object_lastname")).clear();
		driver.findElement(By.id("object_lastname")).sendKeys("test");
		driver.findElement(By.id("object_firstname")).clear();
		driver.findElement(By.id("object_firstname")).sendKeys("test");
		driver.findElement(By.id("object_password")).clear();
		driver.findElement(By.id("object_password")).sendKeys("test");
		driver.findElement(By.id("object_email")).clear();
		driver.findElement(By.id("object_email")).sendKeys("tes@test.com");
		driver.findElement(By.id("object_address")).clear();
		driver.findElement(By.id("object_address")).sendKeys("test");
		driver.findElement(By.name("_save")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
		driver.findElement(By.id("object_password")).clear();
		driver.findElement(By.id("object_password")).sendKeys("testtest");
		driver.findElement(By.name("_save")).click();
		driver.findElement(By.linkText("tes@test.com")).click();
		driver.findElement(By.cssSelector("p.crudDelete > input[type=\"submit\"]")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
