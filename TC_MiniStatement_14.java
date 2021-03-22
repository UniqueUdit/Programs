package com.banking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.banking.pageObject.BalanceEnquiry;
import com.banking.pageObject.DeleteAccount;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.MiniStatement;
import com.banking.pageObject.NewAccount;
public class TC_MiniStatement_14 extends BaseClass {
	String data;
@Test
public void MiniStatementTest() throws Exception {

 driver.get(baseUrl);
 LoginPage lp=new LoginPage(driver);
 lp.setUserName(username);
 logger.info("User name is provided");
 lp.setPassword(password);
 logger.info("Passsword is provided");
 lp.clickSubmit();
 MiniStatement ms = new MiniStatement(driver);
 ms.clickBalanceEnquiry();
 try {
     File myObj = new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\AccountId.txt");
     Scanner myReader = new Scanner(myObj);
     while (myReader.hasNextLine()) {
        data = myReader.nextLine();
      
     }
     myReader.close();
   } catch (FileNotFoundException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
 ms.setAccountNo(data);
 logger.info("Entered AccountNo");
 ms.clickSubmit();
 
 String tableTag = driver.findElement(By.id("ministmt")).getTagName();
 SoftAssert softAssert = new SoftAssert();
 if(tableTag.contains("table")) {
     softAssert.assertTrue(true);
     System.out.println("table Present");
     
 }
 String titleTag = driver.findElement(By.className("heading3")).getText();
 if(titleTag.contains("Last Five Transaction Details for Account No: "+data)) {
     softAssert.assertTrue(true);
     System.out.println("MiniStatement Generated Successfully");
 }
 
 String TransactionID = driver.findElement(By.xpath("//table[@id='ministmt']/tbody[1]/tr[2]/td[1]")).getText();
 logger.info(TransactionID);

 Boolean cont = driver.findElement(By.linkText("Continue")).isDisplayed();
 System.out.println("Continue = "+cont);

 Boolean home = driver.findElement(By.linkText("Home")).isDisplayed();
 System.out.println("Home = "+home);

}
}	