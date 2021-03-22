package com.banking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
 
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewAccount;
public class TC_NewAccount_06 extends BaseClass {
	String data;
@Test
public void loginTest() throws Exception {

 driver.get(baseUrl);
 LoginPage lp=new LoginPage(driver);
 lp.setUserName(username);
 logger.info("User name is provided");
 lp.setPassword(password);
 logger.info("Passsword is provided");
 lp.clickSubmit();
 NewAccount cust = new NewAccount(driver);
 cust.clickAddNewAccount();
 try {
     File myObj = new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\Customer1.txt");
     Scanner myReader = new Scanner(myObj);
     while (myReader.hasNextLine()) {
        data = myReader.nextLine();
      
     }
     myReader.close();
   } catch (FileNotFoundException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
 cust.setCustomer(data);
 logger.info("Customer id entered");
 cust.setAccountType();
 cust.setInitialdeposit("100000");
 logger.info("initaial deposite entered");
 cust.clickSubmit();
 //String AccountNo = driver.findElement(By.xpath("//td[text()='90630']")).getText();
 String tableTag = driver.findElement(By.id("account")).getTagName();
  SoftAssert softAssert = new SoftAssert();
 if(tableTag.contains("table")) {
     softAssert.assertTrue(true);
     System.out.println("table Present");
 }
 String titleTag = driver.findElement(By.className("heading3")).getText();
 if(titleTag.contains("Account Generated Successfully!!!")) {
     softAssert.assertTrue(true);
     System.out.println("Generated Successfully");
 }
 String AccountID = driver.findElement(By.xpath("//table[@id='account']/tbody[1]/tr[4]/td[2]")).getText();
 logger.info(AccountID);
 String CustomerID = driver.findElement(By.xpath("//table[@id='account']/tbody[1]/tr[5]/td[2]")).getText();
 logger.info(CustomerID);
 
 
 Boolean cont = driver.findElement(By.xpath("//table[@id='account']/tbody[1]/tr[11]/td[1]/a[1]")).isDisplayed();
 System.out.println("Continue = "+cont);

 Boolean home = driver.findElement(By.xpath("html[1]/body[1]/p[1]/a[1]")).isDisplayed();
 System.out.println("Home = "+home);
 File file = new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\AccountId.txt"); //initialize File object and passing path as argument  
 boolean result;  
 try   
 {  
 result = file.createNewFile();  //creates a new file  
 if(result)      // test if successfully created a new file  
 {  
 System.out.println("file created "+file.getCanonicalPath()); //returns the path string  
 }  
 else  
 {  
 System.out.println("File already exist at location: "+file.getCanonicalPath());  
 }  
 }   
 catch (IOException e)   
 {  
 e.printStackTrace();    //prints exception if any  
 } 
 try 
 {
     FileWriter myWriter = new FileWriter("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\AccountId.txt");
     myWriter.write(AccountID);
     myWriter.close();
     }
 catch (IOException e) {
     System.out.println("An error occurred.");
     e.printStackTrace();
   }
}

}