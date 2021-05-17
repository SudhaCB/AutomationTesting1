package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//page locators
		private By emailId = By.cssSelector("#username");
		private By password = By.id("password");
		private By loginButton = By.id("loginBtn");
		private By header = By.xpath("//i18n-string[@data-key='login.signupLink.text']");
		

	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}
	/**
	 * @return the loginButton
	 */
	public WebElement getLoginButton() {
		return getElement(loginButton);
	}
	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getLoginPageTitle() {
		 return getPageTitle();
	}
	
	public String getPageHeader() {
		 return getPageHeader(header);
	}
	
	//With username and password (2 parameters) - Method overloading
	public HomePage doLogin(String username, String password) {
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().click();
		return getInstance(HomePage.class);
	}
	
	//Without username and password(no parameters) - Method overloading
		public void doLogin() {
			getEmailId().sendKeys("");
			getPassword().sendKeys("");
			getLoginButton().click(); 	
		}

		//With username or password (1 parameters) - Method overloading
		public void doLogin(String usercredentials) {
			if(usercredentials.contains("username")) {
				getEmailId().sendKeys(usercredentials.split(":")[1].trim());
			}
			else if(usercredentials.contains("password")) {
				getEmailId().sendKeys(usercredentials.split(":")[1].trim());
			}
			
			getLoginButton().click();
			
		}
	
}
