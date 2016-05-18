package com.serli.selenium;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ##Exercise 3
 * Thanks to the "selenium.browser" and "selenium.baseurl" environment variables, make the previously created test compatible with Chrome, htmlUnit and Internet Explorer
 * You can pass the environment variables in the test "Run Configuration" >  "Arguments" > "VM arguments": -Dselenium.browser=ie
 * @see http://docs.seleniumhq.org/docs/03_webdriver.jsp#internet-explorer-driver
 * @see https://code.google.com/p/selenium/wiki/InternetExplorerDriver
 * @see http://docs.seleniumhq.org/docs/03_webdriver.jsp#chrome-driver
 * @see https://code.google.com/p/selenium/wiki/ChromeDriver
 */
public class Ex3MultiBrowser {

    private WebDriver driver;
    private String baseUrl = "http://localhost:9000";
    private String browser = "firefox";

    @Before
    public void setUp() throws Exception {

        if (System.getProperty("selenium.browser") != null)
            browser = System.getProperty("selenium.browser");

        if (System.getProperty("selenium.baseurl") != null)
            baseUrl = System.getProperty("selenium.baseurl");

        switch (browser) {
            default:
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                // TODO 
                // Driver available at "C:\\formations\\selenium\\Selenium 2\\IEDriverServer.exe"
                break;
            case "htmlunit":
                // TODO
                break;
            case "chrome":
                // TODO
                // Driver available at "C:\\formations\\selenium\\Selenium 2\\chromedriver.exe"
                break;
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void testCreateUser() throws Exception {
        driver.get(baseUrl + "/login");
        assertTrue(isElementPresent(By.id("username")));
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("remember")).click();
        driver.findElement(By.id("remember")).click();
        driver.findElement(By.id("signin")).click();
        driver.findElement(By.linkText("Add")).click();
        driver.findElement(By.id("object_lastname")).clear();
        driver.findElement(By.id("object_lastname")).sendKeys("toto");
        driver.findElement(By.id("object_firstname")).clear();
        driver.findElement(By.id("object_firstname")).sendKeys("titi");
        driver.findElement(By.id("object_password")).clear();
        driver.findElement(By.id("object_password")).sendKeys("tata");
        driver.findElement(By.id("object_email")).clear();
        driver.findElement(By.id("object_email")).sendKeys("tutu");
        driver.findElement(By.id("object_address")).clear();
        driver.findElement(By.id("object_address")).sendKeys("ddsdscd");
        driver.findElement(By.name("_save")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
        // ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
        driver.findElement(By.id("object_password")).clear();
        driver.findElement(By.id("object_password")).sendKeys("tatatoto");
        driver.findElement(By.id("object_email")).clear();
        driver.findElement(By.id("object_email")).sendKeys("tutu@titi.com");
        driver.findElement(By.name("_save")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
        driver.findElement(By.linkText("tutu@titi.com")).click();
        driver.findElement(By.cssSelector("p.crudDelete > input[type=\"submit\"]")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [isTextPresent]]
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
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