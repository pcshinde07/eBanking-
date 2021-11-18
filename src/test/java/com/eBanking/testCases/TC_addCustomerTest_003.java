package com.eBanking.testCases;

import org.apache.commons.lang.RandomStringUtils;
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
		//Assert.assertTrue(ac.verifyLogo());
		ac.clickOnCustomerLink();
		logger.info("Providing Customer Details.....");
		ac.setcustomerName("Pratik");
		ac.selectGender("male");
		ac.custDob("01", "23", "1993");
		ac.setAddress("India");
		ac.setCity("Pune");
		ac.setState("Maharashtra");
		ac.setPinno(411028);
		ac.setMobile("3881092157");
		//how to generate random data , which is useful for email because every time new mail id have to put
		//if we put hardcoded value then it will not accept same data 
		// user defined function 
		String MailID=ac.RandomString()+"@gmail.com";
		ac.setEmail(MailID);
		ac.setPassword("pk@123");
		ac.ClickSubmit();
		logger.info("Validation Started....");
		boolean contains = driver.getPageSource().contains("Customer Registered Successfully");
		if(contains==true) {
			Assert.assertTrue(true);
			
			logger.info("Testcase PASSED");
		}else
		{
			Assert.assertTrue(false);
			logger.info("Testcase FAILED");
		}
		

		
}


}