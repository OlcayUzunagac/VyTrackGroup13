package com.Group13.pages;

import com.Group13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleServicesLogs extends BasePage {
    public VehicleServicesLogs() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div/a[@title='Create Vehicle Services Logs']")
    public WebElement with;
    }