package com.banking.pageObject;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DeleteAccount {
    
    WebDriver driver;
    
    public DeleteAccount(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
        
        
    }
    @FindBy(how = How.XPATH, using ="//a[@href='deleteAccountInput.php']")
    @CacheLookup
    WebElement lnkDeleteAccount;
    @FindBy(name="accountno")
    @CacheLookup
    WebElement txtDeleteAccountNo;
    
    
    
    @FindBy(name="AccSubmit")
    @CacheLookup
    WebElement txtbtnLogin;
    
    public void clickDeleteAccount() {
        lnkDeleteAccount.click();
            
    }
    
    
    public void setAccountNo(String uname)
    {
        txtDeleteAccountNo.sendKeys(uname);
    }
    
    public void clickSubmit()
    {
        txtbtnLogin.click();
    }
}