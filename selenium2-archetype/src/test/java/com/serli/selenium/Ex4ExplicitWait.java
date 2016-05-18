package com.serli.selenium;


import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ##Exercise 4
 * Try the various ways to perform explicit waits :
 *  - By using Thread.sleep()
 *  - By using the WebDriverWait and ExpectedConditions classes 
 */
public class Ex4ExplicitWait {

    private WebDriver driver;
    private String baseUrl = "http://google.fr";
    private String browser = "firefox";

    @Before
    public void setUp() throws Exception {

        if (System.getProperty("selenium.browser") != null)
            browser = System.getProperty("selenium.browser");

        if (System.getProperty("selenium.baseurl") != null)
            baseUrl = System.getProperty("selenium.baseurl");

        switch (browser ) {
            default:
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\formations\\selenium\\Selenium 2\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case "htmlunit":
                driver = new HtmlUnitDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\formations\\selenium\\Selenium 2\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
    
    @Test
    public void googleSearchFail() throws Exception {
        driver.get(baseUrl+"/");
        // TODO search in google without any wait and make sure it is failing
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("selenium");
        driver.findElement(By.id("gbqfb")).click();
        driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
    }
    
    @Test
    public void googleSearchLong() throws Exception {
        driver.get(baseUrl+"/");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("selenium");
        driver.findElement(By.id("gbqfb")).click();
        // TODO use java sleep for 10s here
        driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
    }
    
    @Test
    public void googleSearchGood1() throws Exception {
        driver.get(baseUrl+"/");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("selenium");
        driver.findElement(By.id("gbqfb")).click();
        // TODO fix findAndWait method with your own Condition and wait for 10s
        findAndWait(By.linkText("Selenium - Web Browser Automation"), 10).click();
    }

    private WebElement findAndWait(final By by, int timeout) {
        // Explicit wait if you want greater timeout than implicit
        WebElement myDynamicElement = (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                // TODO find the element by using by and driver, this method will be executed until it returns an element
                throw new UnsupportedOperationException();
            }
        });
        return myDynamicElement;
    }
    
    @Test
    public void googleSearchGoodAndMoreFlexible() throws Exception {
        driver.get(baseUrl+"/");
        driver.findElement(By.id("gbqfq")).clear();
        driver.findElement(By.id("gbqfq")).sendKeys("selenium");
        driver.findElement(By.id("gbqfb")).click();
        // TODO use ExpectedConditions.presenceOfElementLocated
        driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}