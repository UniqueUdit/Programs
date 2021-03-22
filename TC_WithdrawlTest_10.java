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
public class TC_WithdrawlTest_10 extends BaseClass {
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
        
        
        //WITHDRAWL MODULE
        
        
        lp.clickWithdrawl();
        logger.info("Withdrawl module is opened");
        
         //TEST CASE- WHEN ANY FIELDS IS LEFT EMPTY AND TRIED TO SUBMIT
        //EXPECTED RESULT- IT SHOULD GIVE AN ERROR MESSAGE IN POP UP 
        
        lp.wSubmit();
        
        String wEmptyPop=driver.switchTo().alert().getText();
        assertEquals(wEmptyPop,"Please fill all fields");
        if(wEmptyPop.contains("Please fill all fields"))
        {
         //softAssert.assertTrue(true);
         System.out.println("Error message 'Please fill all fields' is given");
        }
        else
        {
         System.out.println("Message is not given");
        }
        driver.switchTo().alert().accept();
        
       
        //ACTUAL RESULT-ERROR MESSAGE IN POP UP IS GIVEN
        
        
        
      //TEST CASE-Account No. is left empty
      //EXPECTED RESULT-'Account Number must not be blank' SHOULD BE DISPLAYED  
        
        
        driver.findElement(By.name("accountno")).click();
        driver.findElement(By.name("ammount")).click();
        String acError = driver.findElement(By.xpath("//label[text()='Account Number must not be blank']")).getText();
        assertEquals(acError,"Account Number must not be blank");
        if(acError.contains("Account Number must not be blank"))
        {
            System.out.println("'Account Number must not be blank' message is given");
            
        }
        else
        {
            System.out.println("'Account Number must not be blank' message is not given");
            
        }   
        //ACTUAL RESULT- Message is given
        
        
      //TEST CASE- Invalid Account no. is given and submitted
      //EXPECTED RESULT- Error should be given
        
        lp.setWAccno("7777");
        logger.info("Entered incorrect AccountNo");
        lp.setWAmmount("1000");
        lp.setWDesc("1000");
        lp.wSubmit();
        String invalidPop=driver.switchTo().alert().getText();
        assertEquals(invalidPop,"Account does not exist");
        if(invalidPop.contains("Account does not exist"))
        {
            System.out.println("Pop-up is shown");
        }
        else
        {
            System.out.println("Pop-up is not shown");
        }
        
        //ACTUAL RESULT - Pop up is shown
        
        driver.switchTo().alert().accept();
        
      //TEST CASE- When Valid details are filled
      //EXPECTED RESULT - It should give correct Transaction details
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
        lp1.setWAccno(data);
        logger.info("Entered correct AccountNo");
        lp1.setWAmmount("10000");
        logger.info("Entered amount");
        lp1.setWDesc("100");
        logger.info("Entered description");
        lp1.dSubmit();
        
      //To check title of the page
        
        String tit=driver.getTitle();
        System.out.println(tit);
        assertEquals(tit,"Guru99 Bank Amount Withdrawal Page");
         if(tit.contains("Guru99 Bank Amount Withdrawal Page"))
         {
             System.out.println("Correct page Title is present");
         }
         else
         {
             System.out.println("Correct page is not present");
         }
         
         //To check if correct transaction detail table is present
         
         String table=driver.findElement(By.xpath("//table[@id='withdraw']")).getAttribute("id");
         assertEquals(table,"withdraw");
         if(table.contains("withdraw"))
         {
             System.out.println("Table is present");
         }
         else
         {
             System.out.println("Table is not present");
         }
         
        //To check if the amount is withdrawal from correct account
         
         String  ac= driver.findElement(By.xpath("//td[text()='Account No']/following-sibling::td")).getText();
         assertEquals(ac,data);
         if(ac.contains(data))
         {
             System.out.println("Withdrawled from correct account");
         }
         else
         {
             System.out.println("Not withdrawled from correct account");
         }
         
        //Actual result- Correct transaction details are present      
            }
    
    
}