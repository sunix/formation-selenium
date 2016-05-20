package com.serli.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManageUserPage extends LoggedPage {

	public ManageUserPage(WebDriver driver) {
		super(driver);
	}

	public boolean isUserEmailDisplayed(String email) {
		try {
			driver.findElement(By.linkText(email));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public EditUserPage editUser(String email) {
		driver.findElement(By.linkText(email)).click();
		return initElements(EditUserPage.class);
	}

}
