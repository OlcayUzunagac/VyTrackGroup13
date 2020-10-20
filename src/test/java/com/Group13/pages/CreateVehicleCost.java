package com.Group13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateVehicleCost extends BasePage{
    @FindBy(className = "select2-chosen")
    public List<WebElement> type;

    @FindBy(css = ".btn.btn-success.action-button")
    public WebElement SaveAndCloseButton;

    @FindBy(css = "a[title='Edit Vehicle Costs']")
    public WebElement Edit;

    @FindBy(css = "[title='Delete Vehicle Costs']")
    public WebElement Delete;

    @FindBy(xpath = "(//div//h3)[2]")
    public WebElement DeleteConfirmation;

    @FindBy (css =".select2-chosen")
    public WebElement Type;
    @FindBy(xpath = "//div[.='Tax Roll']")
    public WebElement taxRoll;
}
