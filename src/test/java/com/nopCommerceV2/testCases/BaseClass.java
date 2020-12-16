package com.nopCommerceV2.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.tools.ant.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.nopCommerceV2.utilities.ReadConfig;

public class BaseClass {
	ReadConfig cg= new ReadConfig();
	public String baseurl=cg.getApplicationUrl();
	public String username=cg.getUsername();
	public String password=cg.getPassword();
	public WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters("browsers")
	public void setup(String browser) {
		
		logger=logger.getLogger("nopCommerceV2");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", cg.getChromePath());
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", cg.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		
		
	}
	
	@AfterClass
	public void TearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}

}
