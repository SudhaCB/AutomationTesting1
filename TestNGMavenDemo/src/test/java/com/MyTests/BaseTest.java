package com.MyTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.myPages.BasePage;
import com.myPages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	public Page page;
	
	
	@BeforeMethod
	/* @Parameters(value= {"browser"}) */
	public void setUp() throws InterruptedException {
		String browser = "chrome";
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("No browser is defined");
		}
		try {
			driver.get("https://app.hubspot.com/login/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(6000);
		page = new BasePage(driver);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
