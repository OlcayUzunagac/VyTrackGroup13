package com.Group13.tests.US_8;

import com.Group13.pages.*;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC141and142_CreationOfVehicleContract extends TestBase {

    //pre condition;(TestBase)
    // Open browser,Login as salesmanager
    //Go to 'Dashboard View' page,
    //Move on the  'Fleet' module,
    //Click on 'Vehicle Contracts' option

    @DataProvider(name = "contract")
    public Object [][] enterData(){
        return new Object[][]{
                {"olci", "250", "50","15000","Apr 12, 2020","May 12, 2020","Sep 12, 2020", "coni", "cart","25250", "extra information" },
                {"George JUHAN", "25", "500","135000","Apr 12, 2020","May 12, 2020","Sep 12, 2020", "Ferrari", "Hamilton","25250", "extra information" }

        };
    }

    @Test(dataProvider = "contract")
    public void CreatVehicleContract(String responsible, String activationCost, String costAmount, String odometer,
                                     String invoiceDate, String  startDate, String expirationDate,   String  vendor, String Driver, String reference, String termsAndConditions) throws InterruptedException {
        //Open browser,Login as salesmanager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();

        //Go to 'Dashboard View' page,
        // Move on the  'Fleet' module,
        //Click on 'Vehicle Contracts' option
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        extentLogger = report.createTest("Creation of Vehicle Contract");
        AllVehicleContractPage vehicleContractsPage = new AllVehicleContractPage();
        vehicleContractsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("click Create Vehicle Contract button");
        BrowserUtils.clickWithJS(vehicleContractsPage.createVehicleContract);


        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        extentLogger.info("verify header of Create Vehicle Page");
        Assert.assertEquals(createVehicleContractPage.headerOfPage.getText(),"Create Vehicle Contract", "verify subtitle");

        Select typeDropdown = createVehicleContractPage.typeOptionsList();
        List<WebElement> typeOptions = typeDropdown.getOptions();
        for (WebElement typeOption : typeOptions) {
            System.out.println("typeOption.getText() = " + typeOption.getText());
        }

        List<String> expectedTypeList = Arrays.asList("","Leasing", "Personal Loan", "Credit Card", "Cash");
        List<String> actualTypeList = BrowserUtils.getElementsText(typeOptions);
        extentLogger.info("verify type Options");
        Assert.assertEquals(expectedTypeList,actualTypeList,"verify type options");


        typeDropdown.selectByVisibleText("Credit Card");
        extentLogger.info("select Credit Card");
        Assert.assertTrue(createVehicleContractPage.creditCardOption.isSelected());

        createVehicleContractPage.responsible.sendKeys(responsible);
        createVehicleContractPage.ActivationCost.sendKeys(activationCost);
        createVehicleContractPage.RecurringCostAmountDepreciated.sendKeys(costAmount);

        Select costAmountDropDown = createVehicleContractPage.costAmountOptionsList();
        List<WebElement> costAmountDropDownOptions = costAmountDropDown.getOptions();

        for (WebElement costAmountDropDownOption : costAmountDropDownOptions) {
            System.out.println("costAmountDropDownOption = " + costAmountDropDownOption.getText());
        }

        List<String> expectedCostAmountOptions = BrowserUtils.getElementsText(costAmountDropDownOptions);
        List<String> actualCostAmountOptions = Arrays.asList("", "No","Daily", "Weekly", "Monthly", "Yearly");
        extentLogger.info("verify Cost Amount Options");
        Assert.assertEquals(expectedCostAmountOptions,actualCostAmountOptions,"verify Cost Amount List");

        costAmountDropDown.selectByVisibleText("Monthly");
        extentLogger.info("verify monthly is selected");
        Assert.assertTrue(createVehicleContractPage.monthly.isSelected());

        extentLogger.info("Enter informations of input boxes");
       createVehicleContractPage.odometerDetails.sendKeys(odometer);
       createVehicleContractPage.inoviceDate.sendKeys(invoiceDate);
       createVehicleContractPage.contractStartDate.sendKeys(startDate);
       createVehicleContractPage.contractExpirationDate.sendKeys(expirationDate);
       createVehicleContractPage.vendor.sendKeys(vendor);
       createVehicleContractPage.driver.sendKeys(Driver);
       createVehicleContractPage.reference.sendKeys(reference);
       createVehicleContractPage.termsAndConditions.sendKeys(termsAndConditions);

       Select statusOptions = createVehicleContractPage.statusOptionsList();
       List<WebElement> OptionsList = statusOptions.getOptions();
        for (WebElement element : OptionsList) {
            System.out.println("element = " + element.getText());
        }

        List<String> expectedList = BrowserUtils.getElementsText(OptionsList);
        List<String> actualList = Arrays.asList("","Active", "Archived");
        extentLogger.info("verify status Options");
        Assert.assertEquals(expectedList,actualList,"verify status list");

        statusOptions.selectByVisibleText("Active");
        extentLogger.info("verify Active status is selected");
        Assert.assertTrue(createVehicleContractPage.active.isSelected());

        extentLogger.info("add vehicle models");
        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleModelAdd);
        BrowserUtils.clickWithJS(createVehicleContractPage.firstAssigned);
        BrowserUtils.clickWithJS(createVehicleContractPage.selectButton);

        extentLogger.info("add vehicle Make");
        BrowserUtils.clickWithJS(createVehicleContractPage.vehicleMakeAdd);
        BrowserUtils.clickWithJS(createVehicleContractPage.firstAssigned);
        BrowserUtils.clickWithJS(createVehicleContractPage.selectButton);
        BrowserUtils.clickWithJS(createVehicleContractPage.saveAndClose);

        ContractInfoPage contractInfoPage = new ContractInfoPage();
        //System.out.println("contractInfoPage.headerOfContract.getText() = " + contractInfoPage.headerOfContract.getText());
        System.out.println("contractInfoPage.headerOfContract.getText() = " + contractInfoPage.getHeaderOfContract(responsible+" "+vendor+" "+ Driver+" "+reference));

        extentLogger.info("Verify Contract is Displayed");
        //Assert.assertEquals(contractInfoPage.headerOfContract.getText(),responsible+" "+vendor+" "+ Driver+" "+reference,"verify header");
        Assert.assertEquals(contractInfoPage.getHeaderOfContract(responsible+" "+vendor+" "+ Driver+" "+reference).getText(),responsible+" "+vendor+" "+ Driver+" "+reference,"verify header");


        extentLogger.info("Go to All Vehicle Contract Page");
        BrowserUtils.clickWithJS(contractInfoPage.vehicleContractLink);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(vehicleContractsPage.getPageSubTitle(),"All Vehicle Contract","verify subtitle");

        extentLogger.info("Get the number of Pages");
        System.out.println("vehicleContractsPage.numberOfPage.getText() = " + vehicleContractsPage.numberOfPage.getText());
        String numberOfPage = vehicleContractsPage.numberOfPage.getText();
        String [] pagenumber = numberOfPage.split(" ");
        System.out.println("Arrays.toString(pagenumber) = " + Arrays.toString(pagenumber));
        int number = Integer.parseInt(pagenumber[1]);
        System.out.println("number = " + number);

        extentLogger.info("Click the next Button 'number of page -1' times");
        for (int i = 1; i < number ; i++) {

            BrowserUtils.clickWithJS(vehicleContractsPage.nextButton);
            BrowserUtils.waitFor(2);
        }


        BrowserUtils.waitFor(3);
        System.out.println("vehicleContractsPage.allrows.getText() = " + vehicleContractsPage.allrows.getText());
        extentLogger.info("verify Vehicle Contract is Displayed on the grid");

        Assert.assertTrue(vehicleContractsPage.allrows.getText().contains(vendor));


        Thread.sleep(3000);


        extentLogger.pass("TC-141 and TC-142 is PASSED");


    }


}
