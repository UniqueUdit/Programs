package com.banking.testCases;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.banking.pageObject.BalanceEnquiry;
import com.banking.pageObject.DeleteAccount;
import com.banking.pageObject.LoginPage;
import com.banking.pageObject.NewAccount;
public class TC_BalanceEnquiry_13 extends BaseClass {
	String data;
    @Test
    public void BalanceEnquiryTest() throws Exception {
        
         driver.get(baseUrl);
         LoginPage lp=new LoginPage(driver);
         lp.setUserName(username);
         logger.info("User name is provided");
         lp.setPassword(password);
         logger.info("Passsword is provided");
         lp.clickSubmit();
         BalanceEnquiry be = new BalanceEnquiry(driver);
         be.clickBalanceEnquiry();
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
         be.setAccountNo(data);
         logger.info("Entered AccountNo");
         be.clickSubmit();
         String tableTag = driver.findElement(By.id("balenquiry")).getTagName();
         SoftAssert softAssert = new SoftAssert();
         if(tableTag.contains("table")) {
             softAssert.assertTrue(true);
             System.out.println("table Present");
         }
         String titleTag = driver.findElement(By.className("heading3")).getText();
         if(titleTag.contains("Balance Details for Account "+data)) {
             softAssert.assertTrue(true);
             System.out.println("Balance Enquiry");
         }
         
         String Balance = driver.findElement(By.xpath("//table[@id='balenquiry']/tbody[1]/tr[16]/td[2]")).getText();
         logger.info(Balance);
         
         Boolean cont = driver.findElement(By.xpath("//table[@id='balenquiry']/tbody[1]/tr[21]/td[1]/a[1]")).isDisplayed();
         System.out.println("Continue = "+cont);
        
         Boolean home = driver.findElement(By.linkText("Home")).isDisplayed();
         System.out.println("Home = "+home);
        
    }
}