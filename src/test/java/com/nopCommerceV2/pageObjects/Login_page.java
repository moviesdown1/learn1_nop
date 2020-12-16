package com.nopCommerceV2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	WebDriver ldriver;
	
	public Login_page(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement textemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	@CacheLookup
	WebElement login;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement logout;
	
	public void setUserName(String uname) {
		textemail.clear();
		textemail.sendKeys(uname);
		
	}
	public void setPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
		
	}
	public void clickLogin() {
		login.click();
		
	}
	public void clickLogout() {
		logout.click();
		
	}
	
}
