package com.serli.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoggedPage {
	protected WebDriver driver;

	public LoggedPage(WebDriver driver) {
		this.driver = driver;
	}

	public HeaderSubPage getHeaderSubPage() {
		return PageFactory.initElements(driver, HeaderSubPage.class);
	}
	
	public <T> T initElements(Class<T> pageClassToProxy){ 
		return PageFactory.initElements(driver, pageClassToProxy);
	}
}
