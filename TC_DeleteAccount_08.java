package com.banking.testCases;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.banking.pageObject.DeleteAccount;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewAccount;
public class TC_DeleteAccount_08 extends BaseClass {
	String data;
    @Test
    public void DeleteTest() throws Exception {
        
         driver.get(baseUrl);
         LoginPage lp=new LoginPage(driver);
         lp.setUserName(username);
         logger.info("User name is provided");
         lp.setPassword(password);
         logger.info("Passsword is provided");
         lp.clickSubmit();
         Thread.sleep(3000);
         DeleteAccount de = new DeleteAccount(driver);
         de.clickDeleteAccount();
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
         de.setAccountNo(data);
         logger.info("Entered AccountNo");
         de.clickSubmit();
        
         String alertMessage = driver.switchTo().alert().getText();
         if(alertMessage.contains("Do you really want to delete this Account?"));
         driver.switchTo().alert().accept();
         
         String alertMessage1 = driver.switchTo().alert().getText();
         if(alertMessage1.contains("Account Deleted Sucessfully"));
         driver.switchTo().alert().accept();
        
         
    }
}