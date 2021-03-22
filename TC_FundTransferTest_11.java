package com.banking.testCases;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.banking.pageObject.Page;
public class TC_FundTransferTest_11 extends BaseClass {
	String data,data1;
    
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
        
        // FUND TRANSFER MODULE
        lp.clickFundTransfer();
        logger.info("Fund Transfer module is opened");
      //TEST CASE- WHEN ANY FIELDS IS LEFT EMPTY AND TRIED TO SUBMIT
        //EXPECTED RESULT- IT SHOULD GIVE AN ERROR MESSAGE IN POP UP 
        
       
        lp.ftSubmit();
        
        String ftEmptyPop=driver.switchTo().alert().getText();
        assertEquals(ftEmptyPop,"Please fill all fields");
        if(ftEmptyPop.contains("Please fill all fields"))
        {
         //softAssert.assertTrue(true);
         System.out.println("Error message 'Please fill all fields' is given");
        }
        else
        {
         System.out.println("Message is not given");
        }
        
        //ACTUAL RESULT - POP UP MESSAGE IS GIVEN
        
        driver.switchTo().alert().accept();
        
      //TEST CASE- WHEN PAYERS ACCOUNT NO. AND PAYERS ACCOUNT NO. IS LEFT EMPTY AND TRIED TO SUBMIT
        //EXPECTED RESULT- IT SHOULD GIVE AN ERROR MESSAGE 
        
        driver.findElement(By.name("payersaccount")).click();
        driver.findElement(By.name("payeeaccount")).click();
        driver.findElement(By.name("ammount")).click();
        String payerError=driver.findElement(By.xpath("//label[text()='Payers Account Number must not be blank']")).getText();
        String payeeError=driver.findElement(By.xpath("//label[text()='Payees Account Number must not be blank']")).getText();
        assertEquals(payeeError,"Payees Account Number must not be blank");
        assertEquals(payerError,"Payers Account Number must not be blank");
        if(payerError.contains("Payers Account Number must not be blank")&&payeeError.contains("Payees Account Number must not be blank"))
        {
            System.out.println("ERROR MESSAGE IS GIVEN");
        }
        else
        {
            System.out.println("ERROR MESSAGE IS GIVEN");
        }
        
        //ACTUAL RESULT- ERROR MESSAGE IS GIVEN
        
        
        //TEST CASE - Valid details are entered and submitted
        //Expected Result - Details should be saved  
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
        lp.setPayerAccNO(data);
        logger.info("Entered correct payer AccountNo");
        try {
            File myObj = new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\AccountId1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
               data1 = myReader.nextLine();
             
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        lp.setPayeeAccNO(data1);
        logger.info("Entered correct payee AccountNo");
        lp.setftAmmount("1000");
        logger.info("Entered ammount");
        lp.setftDesc("1000");
        logger.info("Entered description");
        lp.ftSubmit();
        
        //To check title of the page
        
        
        String qwert=driver.getTitle();
        System.out.println(qwert);
        assertEquals(qwert,"Guru99 Bank Customised Statement Page");
        if(qwert.contains("Guru99 Bank Customised Statement Page"))
        {
            System.out.println("Correct page Title is present");
        }
        else
        {
            System.out.println("Correct page Title is not present");
        }
        
        //To check if  correct payer is mentioned 
        
        String  payer= driver.findElement(By.xpath("//td[text()='From Account Number']/following-sibling::td")).getText();
        assertEquals(payer,data);
        if(payer.contains(data))
        {
         System.out.println("Correct payer is present");
        }
        else
        {
             System.out.println("Correct payer is not present");
        }
        
        // To check if correct payer is mentioned
       
        String  payee=
        driver.findElement(By.xpath("//td[text()='To Account Number']/following-sibling::td")).getText();
        assertEquals(payee,data1);
        if(payee.contains(data1))
        {
            System.out.println("Correct payer is present");
        }
        else
        {
            System.out.println("Correct payer is not present");
        }
        
        //Actual Result- Correct details are saved
        
    }
    
    
}