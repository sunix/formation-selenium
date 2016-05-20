package com.serli.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends LoggedPage {

	public AddUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "object_lastname")
	WebElement lastnameInput;
	@FindBy(id = "object_firstname")
	WebElement firstnameInput;

	@FindBy(id = "object_password")
	WebElement passwordInput;
	@FindBy(id = "object_email")
	WebElement emailInput;
	@FindBy(id = "object_address")
	WebElement addressInput;
	@FindBy(name = "_save")
	WebElement saveButton;

	public ManageUserPage createUser(String lastname, String firstname, String password, String email, String address) {
		lastnameInput.sendKeys(lastname);
		firstnameInput.sendKeys(firstname);
		passwordInput.sendKeys(password);
		emailInput.sendKeys(email);
		addressInput.sendKeys(address);
		saveButton.click();
		return initElements(ManageUserPage.class);
	}

}
