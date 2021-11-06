package com.eBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.pageObjects.BaseClass;
import com.eBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	LoginPage lp;
	
	
	@Test
	public void LoginTest() {
		logger.info("URL is Opened");
		lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Enterted");
		lp.setPassword(password);
		logger.info("Password Entered");
		lp.clickOnLoginbtn();
		logger.info("Clicked Login Btn");
		if(driver.getTitle().equalsIgnoreCase("Guru99 bank manager homepage")) {
			Assert.assertTrue(true);
			logger.info("Login test Pass");
			
		}
		else {
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}
	

}
