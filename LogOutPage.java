package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LogOutPage {
WebDriver ldriver;
    
    public LogOutPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(how = How.XPATH, using ="html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
    @CacheLookup
    WebElement lnklogOut;
    
    public void clickEditCustomer() {
        lnklogOut.click();
            
    }
    
}