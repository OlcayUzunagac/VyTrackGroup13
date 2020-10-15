package com.Group13.tests.US_8;

import com.Group13.pages.AllVehicleContractPage;
import com.Group13.pages.ContractInfoPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_147_DeleteContract extends TestBase {

    @Test
    public void TC_147(){

        extentLogger = report.createTest("Test Case 147_Deleting a VehicleContract");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");
        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();
        BrowserUtils.waitFor(3);
        allVehicleContractPage.firstLine.click();

        extentLogger.info("click delete button");
        ContractInfoPage contractInfoPage = new ContractInfoPage();
        BrowserUtils.waitFor(3);
        contractInfoPage.deleteButton.click();

        extentLogger.info("confirm deleting and see the message on the Screen 'Vehicle Contract deleted");
        contractInfoPage.yesDelete.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(allVehicleContractPage.vehicleConractDeletedMessage.isDisplayed());

    }
}
