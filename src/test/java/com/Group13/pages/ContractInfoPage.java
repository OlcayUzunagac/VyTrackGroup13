package com.Group13.pages;

import com.Group13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractInfoPage extends BasePage{

    @FindBy(xpath = "//h1[@class='user-name'][contains(text(),'Mike Smith Mclaren Hamilton 25250')]")
    public WebElement headerOfContract;

    public WebElement getHeaderOfContract(String headerOfContract){
        String xpath = "//h1[@class='user-name'][contains(text(),'" + headerOfContract + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(linkText = "Vehicle Contract")
    public WebElement vehicleContractLink;

    @FindBy(xpath = "//div[contains(text(),'Schumaher')]")
    public WebElement nameOfResponsible;

    @FindBy(xpath= "//div[@class='pull-left btn-group icons-holder'][2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[.='Yes, Delete']")
    public WebElement yesDelete;
}
