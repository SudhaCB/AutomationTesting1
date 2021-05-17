package com.myPages;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
		
		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			
		}catch(Exception e) {
			System.out.println("some error occured while creating "+locator.toString());
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public void WaitForElementPresent(final By locator) {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Element is not present: "+locator);
		}
	}

	@Override
	public void WaitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error occured in finding title: "+title);
			}
		
	}

	@Override
	public String getPageHeader() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
