package com.banking.testCases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import org.testng.asserts.SoftAssert;
//import org.junit.Test;
import com.banking.pageObject.AddCustomerPage;
import com.banking.pageObject.LoginPage;
import java.lang.Math;
public class TC_AddCustomer_03 extends BaseClass{
  public String customerID;
  @Test
  public void addCustomer() throws Exception
  {
      
      Assertion hardAssert = new Assertion();
      SoftAssert softAssert = new SoftAssert();
      driver.get(baseUrl);
      LoginPage lp=new LoginPage(driver);
      lp.setUserName(username);
      logger.info("User name is provided");
      lp.setPassword(password);
      logger.info("Passsword is provided");
      lp.clickSubmit();
      
      Thread.sleep(3000);
      
      AddCustomerPage cust=new AddCustomerPage(driver);
      
      cust.clickAddNewCustomer();
      
      cust.custName("Winkfir");
      logger.info("Customer Name Entered");
      
      cust.custgender("male");
      logger.info("Gender Selected");
      
      cust.custdob("12","11","2000");
      logger.info("Date Selected");
      
      cust.custaddress("Rajpur Chungi");
      logger.info("Address Entered");
      
      cust.custcity("Agra");
      logger.info("City Entered");
      
      cust.custstate("UP");
      logger.info("State Entered");
    
      cust.custpinno("168616");
      logger.info("Pin Entered");
      
      cust.custtelephoneno("730238345");
      logger.info("Phone Number Entered");
      
      int max = 1000; 
      int min = 1; 
      int range = max - min + 1; 
      int rand = (int)(Math.random() * range) + min;
      cust.custemailid("a1da1"+rand+"932@gmail.com");
      logger.info("Mail Entered");
      
      cust.custpassword("123456790");
      logger.info("Password Entered");
      
      cust.custsubmit();
      logger.info("Submited");
      /*
      String m1 = driver.findElement(By.id("message")).getText();
      if(m1.contains("Customer name must not be blank"))
      {
          isMessagePresent=true;
          logger.info("Message is coming");
      }
      */
      
      Thread.sleep(3000);
      
      String tableTag = driver.findElement(By.id("customer")).getTagName();
      if(tableTag.contains("table"))
      {
          //isTablePresent=true;
          softAssert.assertTrue(true);
          logger.info("Table Present");
      }
      
      String titleTag = driver.findElement(By.cssSelector("table#customer>tbody>tr>td>p")).getText();
      if(titleTag.equals("Customer Registered Successfully!!!"))
      {
          //isTablePresent=true;
          softAssert.assertTrue(true);
          logger.info("Registered Successfully");
      }
      Boolean cont = driver.findElement(By.xpath("//table[@id='customer']/tbody[1]/tr[14]/td[1]/a[1]")).isDisplayed();
      System.out.println("Continue = "+cont);
     
      Boolean home = driver.findElement(By.xpath("html[1]/body[1]/p[1]/a[1]")).isDisplayed();
      System.out.println("Home = "+home);
      
      customerID = driver.findElement(By.xpath("//table[@id='customer']/tbody[1]/tr[4]/td[2]")).getText();
      //System.out.println(customerID);
      logger.info(customerID);
      File file = new File("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\Customer1.txt"); //initialize File object and passing path as argument  
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
          FileWriter myWriter = new FileWriter("C:\\Users\\User8\\OneDrive - HCL Technologies Ltd\\Desktop\\Customer1.txt");
          myWriter.write(customerID);
          myWriter.close();
          }
      catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
  }

}