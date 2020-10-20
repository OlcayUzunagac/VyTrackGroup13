package com.Group13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllVehicleCost extends BasePage{
// public VehicleCost(){PageFactory.initElements(Driver.get(),this);} base page de yazdigimiz icin
    //ve bu classi oraya extend ettigimiz icin tekrar yazmamiza gerek kalmadi


    @FindBy(className = "oro-subtitle")
    public WebElement allVehicleCost;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//td[@data-column-label='Total Price']")
    public List<WebElement> totalCost;

    @FindBy(css = "a[title='Create Vehicle Costs']")
    public WebElement CreateVehicleCost;

    @FindBy(css = "div>a[title='Cancel']")
    public WebElement cancel;
}
