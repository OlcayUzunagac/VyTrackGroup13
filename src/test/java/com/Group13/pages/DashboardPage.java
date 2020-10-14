package com.Group13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    //no need to expilicitly write constructors,
    //because it will use its parents cons.

    @FindBy(xpath = "(//div[@class='message'])[2]")
    public WebElement permissionMessage;


}
