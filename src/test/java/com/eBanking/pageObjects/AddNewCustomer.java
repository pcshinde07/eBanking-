package com.eBanking.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

	@FindBy(name = "addr")
	WebElement address;

	public void setAddress(String Address) {
		address.sendKeys(Address);
	}
}
