package com.serli.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exo1GoogleSearch {

    @Test
    public void test() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.fr");
        driver.quit();
    }

}
