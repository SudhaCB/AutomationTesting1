package com.myPages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver driver) {
		//constructor
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
	}
		
		//abstract methods

	public abstract String getPageTitle();
	public abstract String getPageHeader();
	public abstract WebElement getElement(By locator);
	public abstract void WaitForElementPresent(By locator);
	public abstract void WaitForPageTitle(String title);
	
	public <TPage extends BasePage>TPage getInstance(Class<TPage> pageClass){
		try {
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		//Instead of above line we can use //Initialize the Page with its elements and return it.
        //return PageFactory.initElements(driver,  pageClass);
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public abstract String getPageHeader(By locator);
	
	
	//Note (OB):
	//Without Page Factory we can generate and return a new instance of a page by using below line.
	//return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
	 
	 
}
