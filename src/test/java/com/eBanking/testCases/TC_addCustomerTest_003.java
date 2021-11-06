package com.eBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.AddNewCustomer;
import com.eBanking.pageObjects.BaseClass;
import com.eBanking.pageObjects.LoginPage;

public class TC_addCustomerTest_003 extends BaseClass{
	LoginPage lp;
	AddNewCustomer ac;
	
	@Test
	public void addCustomer() throws InterruptedException{
		lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is Provided");
		lp.setPassword(password);
		logger.info("Password is Provided");
		lp.clickOnLoginbtn();
		logger.info("Clicked Login Btn");
		ac=new AddNewCustomer(driver);
		Assert.assertTrue(ac.verifyLogo());
		ac.clickOnCustomerLink();
		ac.setcustomerName("Pratik");
		//ac.selectGender(WebElement ac.radioButtons);
		ac.selectGender("female");
		Thread.sleep(5000);
		ac.setAddress("At post Hadapsar");

}
}