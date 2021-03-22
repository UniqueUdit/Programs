package com.banking.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class Page {
    
    WebDriver driver;
    String cusId="14879";
    String accNo="90635";
    
    public Page(WebDriver  rdriver)
    {
        driver=rdriver;
        PageFactory.initElements(rdriver, this);
        
        
    }
    
    @FindBy(name="uid")
    @CacheLookup
    WebElement txtusername;
    
    @FindBy(name="password")
    @CacheLookup
    WebElement txtpassword;
    
    @FindBy(name="btnLogin")
    @CacheLookup
    WebElement txtbtnLogin;
    
    @FindBy(how = How.CSS, using = "html>body>div:nth-of-type(3)>div>ul>li:nth-of-type(8)>a")
    @CacheLookup
    WebElement clickDeposit;
    
    @FindBy(how = How.NAME, using = "accountno")
    @CacheLookup
    WebElement txtaccno;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    @CacheLookup
    WebElement dSubmit;
    
    @FindBy(how = How.NAME, using = "ammount")
    @CacheLookup
    WebElement dAmmount;
    
    @FindBy(how = How.NAME, using = "desc")
    @CacheLookup
    WebElement desc;
    
    
    public void setUserName(String uname)
    {
        txtusername.sendKeys(uname);
    }
    
    public void setPassword(String password)
    {
        txtpassword.sendKeys(password);
    }
    public void clickSubmit()
    {
        txtbtnLogin.click();
    } 
    public void setDAccno(String acno)
    {
        txtaccno.sendKeys(acno);
    }
    public void clickDeposit()
    {
        clickDeposit.click();
    } 
    public void dSubmit()
    {
        dSubmit.click();
    } 
    public void setDAmmount(String am)
    {
        dAmmount.sendKeys(am);
    }
    public void setDesc(String descr)
    {
        desc.sendKeys(descr);
    }
    
    //WITHDRAWL
    
    @FindBy(how = How.CSS, using = "html>body>div:nth-of-type(3)>div>ul>li:nth-of-type(9)>a")
    @CacheLookup
    WebElement clickWithdrawl;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    @CacheLookup
    WebElement wSubmit;
    
    @FindBy(how = How.NAME, using = "accountno")
    @CacheLookup
    WebElement wAcno;
    
    @FindBy(how = How.NAME, using = "ammount")
    @CacheLookup
    WebElement wAmmount;
    
    @FindBy(how = How.NAME, using = "desc")
    @CacheLookup
    WebElement wdesc;
    
    
    public void clickWithdrawl()
    {
        clickWithdrawl.click();
    }
    
    public void wSubmit()
    {
        wSubmit.click();
    }
    public void setWAccno(String acno)
    {
        wAcno.sendKeys(acno);
    }
    public void setWAmmount(String am)
    {
        wAmmount.sendKeys(am);
    }
    public void setWDesc(String desc)
    {
        wdesc.sendKeys(desc);
    }
    
    @FindBy(how = How.CSS, using = "html>body>div:nth-of-type(3)>div>ul>li:nth-of-type(11)>a")
    @CacheLookup
    WebElement clickChangePass;
    
    @FindBy(how = How.NAME, using = "sub")
    @CacheLookup
    WebElement cpSubmit;
    
    
    public void clickChangePass()
    {
        clickChangePass.click();
    }
    public void cpSubmit()
    {
        cpSubmit.click();
    }
    
    @FindBy(how = How.CSS, using = "html>body>div:nth-of-type(3)>div>ul>li:nth-of-type(10)>a")
    @CacheLookup
    WebElement clickFundTransfer;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    @CacheLookup
    WebElement ftSubmit;
    
    @FindBy(how = How.NAME, using = "payersaccount")
    @CacheLookup
    WebElement payerAcNo;
    
    @FindBy(how = How.NAME, using = "payeeaccount")
    @CacheLookup
    WebElement payeeAcNo;
    
    @FindBy(how = How.NAME, using = "ammount")
    @CacheLookup
    WebElement ftAmount;
    
    @FindBy(how = How.NAME, using = "desc")
    @CacheLookup
    WebElement ftDesc;
    
    
    public void clickFundTransfer()
    {
        clickFundTransfer.click();
    }
    public void ftSubmit()
    {
        ftSubmit.click();
    }
    public void setPayerAccNO(String acno)
    {
        payerAcNo.sendKeys(acno);
    }
    public void setPayeeAccNO(String acno)
    {
        payeeAcNo.sendKeys(acno);
    }
    public void setftAmmount(String acno)
    {
        ftAmount.sendKeys(acno);
    }
    public void setftDesc(String acno)
    {
        ftDesc.sendKeys(acno);
    }
    
}
