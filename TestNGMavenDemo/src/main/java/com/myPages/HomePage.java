	package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	private By header = By.xpath("//*[@data-key='login.signupLink.text']");

	
	public HomePage(WebDriver driver) {
		super(driver);
	}


	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	//Page actions
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return getPageHeader();
	}
	

}
