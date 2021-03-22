package com.banking.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class DeletePage {
WebDriver ldriver;
    
    public DeletePage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(how = How.XPATH, using ="html[1]/body[1]/div[3]/div[1]/ul[1]/li[4]/a[1]")
    @CacheLookup
    WebElement lnkEditCustomer;
    
    @FindBy(how = How.NAME, using = "cusid")
    @CacheLookup
    WebElement txtCustomerId;
    
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement btnSubmit;
    
    
    public void clickDeleteCustomer() {
        lnkEditCustomer.click();
            
    }
    public void cusId(String id) {
        txtCustomerId.sendKeys(String.valueOf(id));
    }
    
    public void cusSubmit() {
        btnSubmit.click();
    } 
    
}