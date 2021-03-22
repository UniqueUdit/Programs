package com.banking.pageObject;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class BalanceEnquiry {
    
    WebDriver driver;
    
    public BalanceEnquiry(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
        
        
    }
    @FindBy(how = How.XPATH, using ="//a[@href='BalEnqInput.php']")
    @CacheLookup
    WebElement lnkBalanceEnquiry;
    @FindBy(name="accountno")
    @CacheLookup
    WebElement txtBalanceEnquiryNo;
    
    
    
    @FindBy(name="AccSubmit")
    @CacheLookup
    WebElement txtbtnLogin;
    
    public void clickBalanceEnquiry() {
        lnkBalanceEnquiry.click();
            
    }
    
    
    public void setAccountNo(String uname)
    {
        txtBalanceEnquiryNo.sendKeys(uname);
    }
    
    public void clickSubmit()
    {
        txtbtnLogin.click();
    }
}