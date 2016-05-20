package com.serli.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSubPage {

	private WebDriver driver;

	public HeaderSubPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(linkText = "Logout")
	private WebElement logoutLink;

	public LoginPage logout() {
		logoutLink.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

}
