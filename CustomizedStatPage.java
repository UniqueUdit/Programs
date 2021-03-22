package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class CustomizedStatPage {
    WebDriver ldriver;
    
    public CustomizedStatPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(how = How.XPATH, using ="html[1]/body[1]/div[3]/div[1]/ul[1]/li[14]/a[1]")
    @CacheLookup
    WebElement lnkcustStat;
    
    @FindBy(how = How.NAME, using = "accountno")
    @CacheLookup
    WebElement txtAccNo;
    
    @FindBy(how = How.ID_OR_NAME, using = "fdate")
    @CacheLookup
    WebElement txtfdob;
    
    @FindBy(how = How.ID_OR_NAME, using = "tdate")
    @CacheLookup
    WebElement txttdob;
    @CacheLookup
    @FindBy(how = How.NAME, using = "amountlowerlimit")
    WebElement txtminTr;
    
    @CacheLookup
    @FindBy(how = How.NAME, using = "numtransaction")
    WebElement txtnoTr;
    
    @CacheLookup
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement btnSubmit;
    
    public void clickcustStat() {
        lnkcustStat.click();
            
    }
    
    public void custAccNo(String acc) {
        txtAccNo.sendKeys(String.valueOf(acc));
    }
    
    public void custfdob(String mm,String dd,String yy) {
        txtfdob.sendKeys(mm);
        txtfdob.sendKeys(dd);
        txtfdob.sendKeys(yy);        
    }
    
    public void custtdob(String mm,String dd,String yy) {
        txttdob.sendKeys(mm);
        txttdob.sendKeys(dd);
        txttdob.sendKeys(yy);    
    }
    
    public void custminTr(String minTr) {
        txtminTr.sendKeys(String.valueOf(minTr));
    }
    public void custnoTr(String noTr) {
        txtnoTr.sendKeys(noTr);
    }
    
    public void custsubmit() {
        btnSubmit.click();
    }    
}
