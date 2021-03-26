package com.banking.testCases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObject.LoginPage;
import jxl.Sheet;
import jxl.Workbook;

public class TC_LoginExcel_02 extends BaseClass
{
	Workbook wb;
	Sheet sh;
	int rows;

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		logger.info("URL is opened");
		driver.get(baseUrl);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		logger.info("Logout page");
		lp.clickLogout();
		Thread.sleep(3000);
		
		if(isAlertPresent()==false)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Login failed");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	public Object[][] TestDataFeed(){
	
		try{
			wb=Workbook.getWorkbook(new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\Selenium Project\\Banking_Project\\TestData\\LoginData2.xls"));
		
		sh=wb.getSheet(0);
		rows=sh.getRows();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			}
			Object[][] Book2=new Object[rows][sh.getColumns()];
			for(int i=0;i<rows;i++) {
				Book2[i][0]=sh.getCell(0, i).getContents();
				Book2[i][1]=sh.getCell(1, i).getContents();
			}
			return Book2;
	}
	
}
