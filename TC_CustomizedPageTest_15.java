package com.banking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
//import org.junit.Test;

import com.banking.pageObject.CustomizedStatPage;
import com.banking.pageObject.LoginPage;
public class TC_CustomizedPageTest_15 extends BaseClass{
	String data;
    
    @Test
    public void customizedPageTest() throws Exception
    {
        
        driver.get(baseUrl);
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();
        
        Thread.sleep(3000);
        
        CustomizedStatPage cust=new CustomizedStatPage(driver);
        
        cust.clickcustStat();
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
        cust.custAccNo(data);
        logger.info("Account Entered");
        
        cust.custfdob("20","1","2020");
        logger.info("Start Date Selected");
        
        
        cust.custtdob("21","3","2020");
        logger.info("End Date Selected");
        
        cust.custminTr("1000");
        logger.info("Min Transaction Entered");
        
        cust.custnoTr("1");
        logger.info("No of Transaction Entered");
        
        cust.custsubmit();
        logger.info("Submited");
        
        WebDriverWait w = new WebDriverWait(driver, 5);
        if(w.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("Alert not exists");
            else
            System.out.println("Alert exists");
        
        
    }
    
}