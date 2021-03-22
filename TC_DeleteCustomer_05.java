package com.banking.testCases;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.banking.pageObject.AddCustomerPage;
import com.banking.pageObject.DeletePage;
import com.banking.pageObject.EditCustomerPage;
import com.banking.pageObject.LoginPage;
public class TC_DeleteCustomer_05 extends BaseClass {
	String data;
    @Test
    public void editCustomer() throws Exception
    {
    	TC_AddCustomer_03 cus=new TC_AddCustomer_03();
        driver.get(baseUrl);
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();
        
        Thread.sleep(2000);
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
        DeletePage cust=new DeletePage(driver);
        //AddCustomerTest cust1=new AddCustomerTest();
        
        cust.clickDeleteCustomer();
        cust.cusId(data);
        logger.info("Customer Id Entered");
        
        cust.cusSubmit();
        logger.info("Submited");
        
        String alertMsg1 = driver.switchTo().alert().getText();
        assertEquals(alertMsg1, "Do you really want to delete this Customer?");
        driver.switchTo().alert().accept();
   
        String alertMsg2 = driver.switchTo().alert().getText();
        if(alertMsg2.contains("Customer does not exist!!"))
        {
            System.out.println("Customer is already deleted");
            driver.switchTo().alert().accept();
            
        }
        else
        if(alertMsg2.contains("Customer deleted Successfully"))
        {
            System.out.println("Customer is deleted");
            driver.switchTo().alert().accept();
            logger.info("Deleted");
        }
       
    }
}