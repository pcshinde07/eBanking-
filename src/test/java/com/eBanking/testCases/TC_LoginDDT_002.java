package com.eBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.eBanking.pageObjects.BaseClass;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilites.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	XLUtils utils;
	LoginPage lp;
	
	
	@Test(dataProvider="Input Data")
	public void loginDDT(String UserName, String Password){
		lp=new LoginPage(driver);
		lp.setUserName(UserName);
		logger.info("User Name is Provided");
		lp.setPassword(Password);
		logger.info("Password is Provided");
		lp.clickOnLoginbtn();
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent(); // come back to loginpage again
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickOnLogoutbtn();
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	@DataProvider(name="Input Data")
		String[][] getData() throws IOException{
	String path="C:\\Users\\Pratik Shinde\\eclipse-workspace\\introduction\\eBanking\\src\\test\\java\\com\\eBanking\\testData\\Input Data.xlsx";
	utils= new XLUtils(path);
	int rownum=utils.getRowCount("UserName");
	  int colcount= utils.getCellCount("UserName", 1);
		String LoginData[][]=new String [rownum][colcount];
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<colcount;j++) {
				LoginData[i-1][j]=utils.getCellData("UserName", i, j);
				
			}
		}
		return LoginData;
	}
	
	
	

}
