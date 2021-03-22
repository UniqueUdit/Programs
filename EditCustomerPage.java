package com.banking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class EditCustomerPage {
WebDriver ldriver;
    
    public EditCustomerPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    @FindBy(how = How.XPATH, using ="(//ul[@class='menusubnav']//a)[3]")
    @CacheLookup
    WebElement lnkEditCustomer;
    
    @FindBy(how = How.NAME, using = "cusid")
    @CacheLookup
    WebElement txtCustomerId;
    @FindBy(how = How.NAME, using = "city")
    WebElement txtcity;
    @CacheLookup
    @FindBy(how = How.NAME, using = "AccSubmit")
    WebElement btnSubmit;
    @CacheLookup
    @FindBy(how = How.NAME, using = "sub")
    WebElement btnSubmit1;
    @CacheLookup
    @FindBy(how = How.NAME, using = "state")
    WebElement txtstate;
    
    public void clickEditCustomer() {
        lnkEditCustomer.click();
            
    }
    public void cusId(String id) {
        txtCustomerId.sendKeys(String.valueOf(id));
    }
    
    public void custcity(String ccity) {
        txtcity.sendKeys(ccity);
    }
    public void custstate(String cstate) {
        txtstate.sendKeys(cstate);
    }
    public void cusSubmit() {
        btnSubmit.click();
    } 
    
    public void cusSubmit1() {
        btnSubmit1.click();
    } 
    
    
}