package com.banking.testCases;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;
import com.banking.pageObject.LogOutPage;
import com.banking.pageObject.LoginPage;
public class TC_LogOutTest_16 extends BaseClass {
    @Test
    public void logout() throws Exception
    {
        driver.get(baseUrl);
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();
        
        Thread.sleep(2000);
        
        LogOutPage cust=new LogOutPage(driver);
        cust.clickEditCustomer();
        
        String alertMsg1 = driver.switchTo().alert().getText();
        assertEquals(alertMsg1, "You Have Succesfully Logged Out!!");
        driver.switchTo().alert().accept();
   
        logger.info("Log Out");
        
    }
}