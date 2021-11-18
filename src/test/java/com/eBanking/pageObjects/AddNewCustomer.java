package com.eBanking.pageObjects;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	WebDriver ldriver;

	public AddNewCustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@class='logo']")
	WebElement logo;

	public boolean verifyLogo() {
		boolean Logo = logo.isDisplayed();
		return Logo;
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']")
	WebElement allLinks;

	public boolean verifyAllLinks() {
		boolean links = allLinks.isDisplayed();
		return links;
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	WebElement newCustomer;

	public void clickOnCustomerLink() {
		newCustomer.click();
	}

	@FindBy(name = "name")
	WebElement inputCustomerName;

	public void setcustomerName(String Cname) {
		inputCustomerName.sendKeys(Cname);
	}

	@FindBy(name="rad1")
	WebElement rbGender;

	public void selectGender(String gender) {
		rbGender.click();
	}
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement txtbod;
	
	public void custDob(String mm, String dd,String yyyy) {
		txtbod.sendKeys(mm);
		txtbod.sendKeys(dd);
		txtbod.sendKeys(yyyy);
	}

	@FindBy(name = "addr")
	WebElement address;

	public void setAddress(String Address) {
		address.sendKeys(Address);
	}
	

	
	@FindBy(how=How.NAME, using="city")
	WebElement txtcity;
	
	public void setCity(String CityName) {
		txtcity.sendKeys(CityName);
	}
	
	@FindBy(how=How.NAME, using = "state")
	WebElement txtstate;
	
	public void setState(String StateName) {
		txtstate.sendKeys(StateName);
	}
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtPinno;
	
	public void setPinno(int Pinno) {
		txtPinno.sendKeys(String.valueOf(Pinno));
	}
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txtMobileno;
	
	public void setMobile(String mobileNo) {
		txtMobileno.sendKeys(mobileNo);
	}
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement emailid;
	
	public void setEmail(String Email) {
		emailid.sendKeys(Email);
	}
	public  String RandomString() 
	{
		String randomAlphabeticString = RandomStringUtils.randomAlphabetic(8);
		return(randomAlphabeticString);
	}
	
	@FindBy(how=How.NAME, using="password")
	WebElement password;
	
	public void setPassword(String Pass) {
		password.sendKeys(Pass);
	}
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	public void ClickSubmit() {
		btnSubmit.click();
	}
}
