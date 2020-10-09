package com.Group13.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.element.Element;

public class CreateVehicleContractPage extends BasePage{


    @FindBy (xpath = "//h1[contains(text(),'Create Vehicle Contract')]")
    public WebElement headerOfPage;

    @FindBy(css = "[name='custom_entity_type[Type]']")
    public WebElement typeOptions;

         @FindBy(xpath = "//option[contains(text(),'Leasing')]")
    public WebElement leasingOption;

         @FindBy(xpath = "//option[contains(text(),'Personal Loan')]")
    public WebElement personalLoanOption;

         @FindBy(xpath = "//option[contains(text(),'Credit Card')]")
    public WebElement creditCardOption;

         @FindBy(xpath = "//option[contains(text(),'Cash')]")
    public WebElement cashOption;

    @FindBy(css = "[name='custom_entity_type[Responsible]']")
    public WebElement responsible;

    @FindBy(css = "input[id*='custom_entity_type_ActivationCost']")
    public WebElement ActivationCost;

    @FindBy(css = "input[id*='custom_entity_type_RecurringCostAmount']")
    public WebElement RecurringCostAmountDepreciated;

    @FindBy(name = "custom_entity_type[RecurringCostAm]")
    public WebElement costAmountOptions;

    @FindBy(css = "option[value*='monthly']")
    public WebElement monthly;

    @FindBy(name = "custom_entity_type[OdometerDetails]")
    public WebElement odometerDetails;

    @FindBy(css = "input[id*='date_selector_custom_entity_type_InoviceDate-uid-']")
    public WebElement inoviceDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractStartDate-uid-')]")
    public WebElement contractStartDate;

    @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ContractExpirationDate-uid-')]")
    public WebElement contractExpirationDate;

    @FindBy(name = "custom_entity_type[Vendor]")
    public WebElement vendor;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driver;

    @FindBy(name = "custom_entity_type[ContractReference]")
    public WebElement reference;

    @FindBy(name = "custom_entity_type[TermsandConditions]")
    public WebElement termsAndConditions;

    @FindBy(name = "custom_entity_type[Status]")
    public WebElement statusOptions;

    @FindBy(xpath = "//option[contains(text(),'Active')]")
    public WebElement active;

    @FindBy(xpath = "(//button[contains(@class,'btn btn-medium add-btn')])[1]")
    public WebElement vehicleModelAdd;

    @FindBy(xpath = "(//button[contains(@class,'btn btn-medium add-btn')])[2]")
    public WebElement vehicleMakeAdd;

    @FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
    public WebElement firstAssigned;

    @FindBy(xpath = "//button[contains(text(),'Select')]")
    public WebElement selectButton;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndClose;

    @FindBy(xpath = "//label[contains(text(),'Service')]")
    public WebElement service;

    @FindBy(xpath = "//a[@title='Cancel'][//a[contains(text(),'Cancel')]]")
    public WebElement cancelButton;



















    public Select typeOptionsList(){
        return new Select(typeOptions);
    }
    public Select costAmountOptionsList(){
        return new Select(costAmountOptions);
    }
    public Select statusOptionsList(){
        return new Select(statusOptions);
    }


}
