package com.banking.pageObject;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class NewAccount {
   
    WebDriver driver;
   
    public NewAccount(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
       
       
    }
    @FindBy(how = How.XPATH, using ="//a[@href='addAccount.php']")
    @CacheLookup
    WebElement lnkAddNewAccount;
    @FindBy(name="cusid")
    @CacheLookup
    WebElement txtCustomer;
   
    @FindBy(name="selaccount")
    @CacheLookup
    WebElement txtAccountType;
   
    @FindBy(name="inideposit")
    @CacheLookup
    WebElement txtInitialdeposit;
   
    @FindBy(name="button2")
    @CacheLookup
    WebElement txtbtnLogin;
   
    public void clickAddNewAccount() {
        lnkAddNewAccount.click();
           
    }
   
   
    public void setCustomer(String uname)
    {
        txtCustomer.sendKeys(uname);
    }
   
    public void setAccountType() {
        txtAccountType.click();
    }
   
    public void setInitialdeposit(String password)
    {
        txtInitialdeposit.sendKeys(password);
    }
    public void clickSubmit()
    {
        txtbtnLogin.click();
    }
}