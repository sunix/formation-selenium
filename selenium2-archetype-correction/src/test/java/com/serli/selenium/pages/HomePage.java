package com.serli.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends LoggedPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Add")
	WebElement addLink;

	public AddUserPage gotoAddUserPage() {
		addLink.click();
		return initElements(AddUserPage.class);
	}
}
