package com.Group13.pages;

import com.Group13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsInfoPage extends BasePage {

    public WebElement getTitle(String title){
        String xpath = "//div[contains(text(),'"+title+"')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    public WebElement getDescription(String description){
        String path = "//span[contains(text(),'"+description+"')]";
        return Driver.get().findElement(By.xpath(path));
    }

    public WebElement getStart(String startDate){
        String path = "//div[contains(text(),'"+startDate+"')]";
        return Driver.get().findElement(By.xpath(path));
    }

    public WebElement getEnd(String endDate){
        String path = "//div[contains(text(),'"+endDate+"')]";
        return Driver.get().findElement(By.xpath(path));
    }

    @FindBy(xpath = "//label[contains(text(),'All-day event')]/../div/div")
    public  WebElement allDayEvent;

    @FindBy(xpath = "//label[contains(text(),'Organizer')]/../div/div/div/a")
    public WebElement organizer;

    @FindBy(xpath = "//label[contains(text(),'Guests')]/../div/div/div/div/ul/li//span//a")
    public WebElement guests;

    @FindBy(xpath = "//label[contains(text(),'Recurrence')]/../div/div")
    public WebElement recurrence;

    @FindBy(xpath = "//label[contains(text(),'Call via Hangout')]/../div/div")
    public WebElement callViaHangout;

}














