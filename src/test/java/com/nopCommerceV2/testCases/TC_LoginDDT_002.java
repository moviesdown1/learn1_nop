package com.nopCommerceV2.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopCommerceV2.pageObjects.Login_page;
import com.nopCommerceV2.utilities.xlutils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData") // small "d"
	public void LoginTest(String user,String pwd) throws IOException, InterruptedException {
		driver.get(baseurl);
		driver.manage().window().maximize();  
		logger.info("url is opened....");
		Login_page lp= new Login_page(driver);
		
		lp.setUserName(user);
		logger.info("username is provided");
		
		lp.setPassword(pwd);
		logger.info("password is provided");
		
		lp.clickLogin();
		logger.info("login button clicked");
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{	
			
			lp.clickLogout();
			logger.info("Login passed");
			Assert.assertTrue(true);
		}
		else
		{
			
			captureScreen(driver,"LoginTest");
			logger.info("Login failed");
			Assert.assertTrue(false);
		}
	
		
	}
	
	@DataProvider(name="LoginData") // capital "D"
	public String[][] getData() throws IOException {
		
		String excelfilepath=System.getProperty("user.dir")+"/src/test/java/com/nopCommerceV2/testData/LoginData.xlsx";
		int totalrow = xlutils.getrowcount(excelfilepath, "Sheet1");
		int totalcolumn=xlutils.getcellcount(excelfilepath, "Sheet1", 1);
		String logindata[][]=new String [totalrow][totalcolumn];
		for(int i=1;i<=totalrow;i++)
		{
			for(int j=0;j<totalcolumn;j++)
			{
				logindata[i-1][j]=xlutils.getcelldata(excelfilepath, "Sheet1", i, j);
				
			}
		}
		return logindata;
		
	}

}
