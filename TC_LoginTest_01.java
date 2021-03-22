package com.banking.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;

public class TC_LoginTest_01 extends BaseClass {

	@Test
	public void loginTest() throws Exception {
		
		logger.info("URL is opened");
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		
		
		String title=driver.getTitle();
		System.out.println(title);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			{
				Assert.assertTrue(true);
			}
		else
		{
			Assert.assertFalse(false);
		}
	}
	
}
