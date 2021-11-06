package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy (name="uid")
	WebElement txtUserName;
	
	@FindBy (name="password")
	WebElement txtPassword;
	
	@FindBy (name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath="(//ul[@class='menusubnav']/child::li)[15]")
	WebElement logoutbtn;
	
	
	//Now Write Methods for Actions
	
	public void setUserName(String Uname) {
		txtUserName.sendKeys(Uname);
		}
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}

	public void clickOnLoginbtn() {
		btnLogin.click();
	}
	
	public void clickOnLogoutbtn() {
		logoutbtn.click();
	}
}
