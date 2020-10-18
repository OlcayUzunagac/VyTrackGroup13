package com.Group13.pages;

import com.Group13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(),'Options')]")
    public WebElement options;

    @FindBy(xpath = "//label[contains(text(),'of')][1]")
    public WebElement of;


    @FindBy(xpath = "//input[@type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement rightArrow;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement dataSize100;

    @FindBy(xpath = "//label[contains(text(),'of')]")
    public WebElement totalPageNumber;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> row;


    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement RecordsNumber;


    @FindBy(xpath = "(//tbody//td/input)[1]")
    public WebElement rowsCheckBox;

    public WebElement setRowsCheckBox(String rowsnumber){
        String xpath = "(//tbody//td/input)[" + rowsnumber + "]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//td[@data-column-label='Title'][contains(text(),'Testers meeting')]")
    public WebElement firstRow;

    public WebElement getFirstRow(String title) {
        String xpath = "//td[@data-column-label='Title'][contains(text(),'" + title + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

}