package com.serli.selenium.concordion;

import org.concordion.api.extension.Extension;
import org.concordion.ext.ScreenshotExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.serli.selenium.pages.AddUserPage;
import com.serli.selenium.pages.EditUserPage;
import com.serli.selenium.pages.HomePage;
import com.serli.selenium.pages.LoginPage;
import com.serli.selenium.pages.ManageUserPage;

@RunWith(ConcordionRunner.class)
public class TestCreateUser {

    @Extension
    public ResourceConcordionExtension resourceExtension = new ResourceConcordionExtension();

    protected WebDriver driver;

    protected HomePage homepage;

    protected ManageUserPage manageUserPage;

    @Extension
     public ScreenshotExtension screenshotExtension = new ScreenshotExtension();


    @Before
    public void before() {
        driver = new FirefoxDriver();
        screenshotExtension.setScreenshotOnAssertionSuccess(true);
        screenshotExtension.setScreenshotTaker(new SeleniumScreenshotTaker(driver));
    }

    public String login() {
        return "fix me!";
    }

    
    @After
    public void after() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
