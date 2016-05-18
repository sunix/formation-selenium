package com.serli.selenium;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * ##Exercise 1
 * Inside the 'com.serli.selenium' package create a Test class to test the browsing of the site : 'http://www.google.fr'
 */
public class Ex1GoogleSearch {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
    }

    @Test
    public void googleSearch() throws Exception {
        // Open the webapp
        
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}