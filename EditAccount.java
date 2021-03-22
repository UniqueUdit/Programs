package com.banking.pageObject;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EditAccount {
   
    WebDriver driver;
   
    public EditAccount(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
       
       
    }
    @FindBy(how = How.XPATH, using ="//a[@href='editAccount.php']")
    @CacheLookup
    WebElement lnkAddEditAccount;
    @FindBy(name="accountno")
    @CacheLookup
    WebElement txtAccountNo;
   
   
   
    @FindBy(name="AccSubmit")
    @CacheLookup
    WebElement txtbtnLogin;
   
    public void clickAddEditAccount() {
        lnkAddEditAccount.click();
           
    }
   
   
    public void setAccountNo(String uname)
    {
        txtAccountNo.sendKeys(uname);
    }
   
    public void clickSubmit()
    {
        txtbtnLogin.click();
    }
}