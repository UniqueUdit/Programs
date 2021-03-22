package com.banking.testCases;

import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
 
import com.banking.pageObject.Page;
public class TC_DepositTest_09 extends BaseClass {
    String data;
    
    @Test
    public void loginTest() throws Exception {
        
        logger.info("URL is opened");
        driver.get(baseUrl);
        Page lp = new Page(driver);
        Page lp1 = new Page(driver);
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
        
        
        
        //DEPOSIT MODULE  
        
        
         lp.clickDeposit();
         logger.info("Deposit module is opened");
         
         //TEST CASE- WHEN ANY FIELDS IS LEFT EMPTY AND TRIED TO SUBMIT
         //EXPECTED RESULT- IT SHOULD GIVE AN ERROR MESSAGE IN POP UP 
         logger.info("All fields are empty");
         lp.dSubmit();
         
         String demptyPop=driver.switchTo().alert().getText();
         assertEquals(demptyPop,"Please fill all fields");
         if(demptyPop.contains("Please fill all fields"))
         {
            
             System.out.println("Error message 'Please fill all fields' is given");
         }
         else
         {
             System.out.println("Message is not given");
         }
         driver.switchTo().alert().accept();
         
         // ACTUAL RESULT- Pop-Up message is given(PASSED)
         
         
         
         //TEST CASE-Account No. is left empty
         //EXPECTED RESULT-'Account Number must not be blank' SHOULD BE DISPLAYED   
         driver.findElement(By.name("accountno")).click();
         driver.findElement(By.name("ammount")).click();
         String d1error = driver.findElement(By.id("message2")).getText();
         assertEquals(d1error,"Account Number must not be blank");
         if(d1error.contains("Account Number must not be blank"))
         {
             System.out.println("Error  message 'Account Number must not be blank' is given");
         }
         else 
         {
             System.out.println("Message is given");
         }
         //ACTUAL RESULT -Error message is given
         
         
         
         
         //TEST CASE- Invalid Account no. is given and submitted
         //EXPECTED RESULT- Error should be given
         
         
         
         lp.setDAccno("7777");
         logger.info("Entered incorrect AccountNo");
         lp.setDAmmount("1000");
         lp.setDesc("1000");
         lp.dSubmit();
         String dpop1=driver.switchTo().alert().getText();
         assertEquals(dpop1,"Account does not exist");
         if(dpop1.contains("Account does not exist"))
         {
             System.out.println("'Account does not exist' pop-up is shown");
         }
         else
         {
             System.out.println("Pop-up is not shown");
         }
         
         //ACTUAL RESULT- Pop-up is shown
         
         
         
         //TEST CASE- When Valid details are filled
         //EXPECTED RESULT - It should give correct Transaction details
         
         
         
         
         driver.switchTo().alert().accept();
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
         lp1.setDAccno(data);
         logger.info("Entered AccountNo");
         lp1.setDAmmount("1000");
         lp1.setDesc("1000");
         lp1.dSubmit();
         
         //To check the title of page
         
         String s=driver.getTitle();
         System.out.println(s);
         assertEquals(s,"Guru99 Bank Amount Deposit Page");
         if(s.contains("Guru99 Bank Amount Deposit Page"))
         {
             System.out.println("Correct page Title is present");
         } else
         {
             System.out.println("Correct page Title is not present");
         }
         
         
         
         // To check if correct transaction detail table is present
         
         
         
         String table=driver.findElement(By.xpath("//table[@id='deposit']")).getAttribute("name");
         System.out.println(table);
         assertEquals(table,"deposit");
         if(table.contains("deposit"))
         {
             System.out.println("TABLE IS PRESENT");
         }
         else
         {
             System.out.println("TABLE IS NOT PRESENT");
         }
         
           
         // To check if amount is credited into right account
        
         String ac = driver.findElement(By.xpath("//table[@id='deposit']/tbody[1]/tr[7]/td[2]")).getText();
         assertEquals(ac,data);
         if(ac.contains(data))
         {
             System.out.println("Credited into right Account");
         }
         else
         {
             System.out.println("Not credited into right Account");
         }
         
         //ACTUAL RESULT - Correct transaction details are given
         
         
    }
    
}