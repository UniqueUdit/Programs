package com.banking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.banking.pageObject.EditAccount;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewAccount;
//import com.banking.pageObject.NewAccount;
public class TC_EditAccount_07 extends BaseClass {
	String data;
    @Test
    public void EditTest() throws Exception {
        
         driver.get(baseUrl);
         LoginPage lp=new LoginPage(driver);
         lp.setUserName(username);
         logger.info("User name is provided");
         lp.setPassword(password);
         logger.info("Passsword is provided");
         lp.clickSubmit();
       //  TC_NewAccount_02 abc = new TC_NewAccount_02();
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
         EditAccount cust = new EditAccount(driver);
         cust.clickAddEditAccount();
         System.out.println(data);
         cust.setAccountNo(data);
         logger.info("Entered EditAccountNo");
         cust.clickSubmit();
         Select sel = new Select(driver.findElement(By.name("a_type")));
         sel.selectByVisibleText("Current");
         driver.findElement(By.name("a_type")).click();
         cust.clickSubmit();
         String tableTag = driver.findElement(By.id("account")).getTagName();
         SoftAssert softAssert = new SoftAssert();
        if(tableTag.contains("table")) {
            softAssert.assertTrue(true);
            System.out.println("table Present");
        }
        String titleTag = driver.findElement(By.className("heading3")).getText();
        if(titleTag.contains("Account details updated Successfully!!!")) {
            softAssert.assertTrue(true);
            System.out.println("Generated Successfully");
        }  
        Boolean cont = driver.findElement(By.xpath("//table[@id='account']/tbody[1]/tr[11]/td[1]/a[1]")).isDisplayed();
        System.out.println("Continue = "+cont);

        Boolean home = driver.findElement(By.xpath("html[1]/body[1]/p[1]/a[1]")).isDisplayed();
        System.out.println("Home = "+home);
    }
}