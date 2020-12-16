package com.nopCommerceV2.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.Login_page;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseurl);
		logger.info("url is opened....");
		Login_page lp= new Login_page(driver);
		
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickLogin();
		logger.info("login button clicked");
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration")) // intentionally we have given wrong title to fail the test
		{	
			
			lp.clickLogout();
			logger.info("Login passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Login failed");
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			
			
		}
	}
	
	
	

}
