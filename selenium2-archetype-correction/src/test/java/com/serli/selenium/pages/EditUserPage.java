package com.serli.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage extends LoggedPage {

	public EditUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input[value=\"Delete User\"]")
	WebElement deleteButton;

	public ManageUserPage deleteUser() {
		deleteButton.click();
		return initElements(ManageUserPage.class);
	}

}
