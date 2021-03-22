package com.banking.testCases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.banking.pageObject.AddCustomerPage;
import com.banking.pageObject.EditCustomerPage;
import com.banking.pageObject.LoginPage;
public class TC_EditCustomer_04 extends BaseClass {
	String data;
    @Test
    public void editCustomer() throws Exception
    {
    	
        driver.get(baseUrl);
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();
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
        Thread.sleep(3000);
        EditCustomerPage cust=new EditCustomerPage(driver);
        
        cust.clickEditCustomer();
        cust.cusId(data);
        logger.info("Customer Id Entered");
        
        cust.cusSubmit();
        logger.info("Submited");
        
        //AddCustomerPage cust1=new AddCustomerPage(driver);
        driver.findElement(By.xpath("//input[@name='city']")).clear();
        
        cust.custcity("abc");
        logger.info("City Entered");
        
        driver.findElement(By.cssSelector("html>body>table>tbody>tr>td>table>tbody>tr:nth-of-type(9)>td:nth-of-type(2)>input")).clear();
        
        cust.custstate("xyz");
        logger.info("State Entered");
        
        cust.cusSubmit1();
        logger.info("Edit Submited");
        
        String tableTag = driver.findElement(By.id("customer")).getTagName();
        assertEquals(tableTag, "table");
        logger.info("Table Exist");
        
        String titleTag = driver.findElement(By.cssSelector("table#customer>tbody>tr>td>p")).getText();
        assertEquals(titleTag, "Customer details updated Successfully!!!");
        logger.info("Updated Title Exist");
        
        String cityC = driver.findElement(By.cssSelector("table#customer>tbody>tr:nth-of-type(9)>td:nth-of-type(2)")).getText();
        assertEquals(cityC, "abc");
        logger.info("Updated City Exist");
        
        String stateC = driver.findElement(By.cssSelector("table#customer>tbody>tr:nth-of-type(10)>td:nth-of-type(2)")).getText();
        assertEquals(stateC, "xyz");
        logger.info("Updated State Exist");
        Boolean cont = driver.findElement(By.xpath("//table[@id='customer']/tbody[1]/tr[14]/td[1]/a[1]")).isDisplayed();
        System.out.println("Continue = "+cont);
       
        Boolean home = driver.findElement(By.xpath("html[1]/body[1]/p[1]/a[1]")).isDisplayed();
        System.out.println("Home = "+home);
        
    }
}