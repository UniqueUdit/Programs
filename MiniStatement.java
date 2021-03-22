package com.banking.pageObject;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MiniStatement {
    
    WebDriver driver;
    
    public MiniStatement(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
        
        
    }
    @FindBy(how = How.XPATH, using ="//a[@href='MiniStatementInput.php']")
    @CacheLookup
    WebElement lnkMiniStatement;
    @FindBy(name="accountno")
    @CacheLookup
    WebElement txtMiniStatementNo;
    
    
    
    @FindBy(name="AccSubmit")
    @CacheLookup
    WebElement txtbtnLogin;
    
    public void clickBalanceEnquiry() {
        lnkMiniStatement.click();
            
    }
    
    
    public void setAccountNo(String uname)
    {
        txtMiniStatementNo.sendKeys(uname);
    }
    
    public void clickSubmit()
    {
        txtbtnLogin.click();
    }
}