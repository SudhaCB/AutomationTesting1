package com.MyTests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.myPages.HomePage;
import com.myPages.LoginPage;

public class LoginTest extends BaseTest {
	
@Test(priority=1)
	public void loginPageTitle() {
		String title=page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "");
	}

@Test(priority=2)
public void loginPageHeader() {
	String header=page.getInstance(LoginPage.class).getPageHeader();
	System.out.println(header);
	//Assert.assertEquals(header, "");
}

@Test(priority=3)
public void doLoginTest() {
	HomePage homepage = page.getInstance(LoginPage.class).doLogin("ss", "ssss");
	String header = homepage.getHomePageHeader();
	System.out.println(header);
	//Assert.assertEquals(header, "");
}


}
