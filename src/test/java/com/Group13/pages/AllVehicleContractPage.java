package com.Group13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllVehicleContractPage extends BasePage {


    //@FindBy(xpath = "//a[@title='Create Vehicle Contract']")
    //public WebElement CreateVehicleContractBtn;

    @FindBy(css = "[class='btn main-group btn-primary pull-right ']")
    public WebElement createVehicleContract;

    @FindBy(xpath = "//i[contains(text(),'Next')]")
    public WebElement nextButton;



    @FindBy(xpath = "//tbody")
    public WebElement allrows;








    // @FindBy(xpath = "//label[contains(text(),'of 2 |')]")
    @FindBy(xpath = "//label[contains(text(),'of')]" )
    public WebElement numberOfPage;



    @FindBy(xpath = "(//*[@href='javascript:void(0);'])[5]")
    public WebElement threepoint;

    @FindBy(xpath = "//body/ul[1]/li[1]/ul[1]/li[2]/a[1]/i[1]")
    public WebElement editIcon;





}
