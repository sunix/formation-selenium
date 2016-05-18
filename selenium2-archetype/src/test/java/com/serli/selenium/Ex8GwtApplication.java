package com.serli.selenium;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ##Exercise 8
 * Go to the following web page : http://gwt.google.com/samples/Showcase/Showcase.html#!CwDatePicker
 *          - click on the following date : 20 october 2012
 *          - Check with an assertion that the date of '20 october 2012' has been correctly taken in account.
 */
public class Ex8GwtApplication {
	private WebDriver driver;
	private String baseUrl =  "http://gwt.google.com";
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		//driver = new HtmlUnitDriver(true);
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testGwt() throws Exception {
	    // TODO Go to the following web page : http://gwt.google.com/samples/Showcase/Showcase.html#!CwDatePicker
	    // TODO click on the following date : 20 october 2012
	    // TODO Check with an assertion that the date of '20 october 2012' has been correctly taken in account.
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
