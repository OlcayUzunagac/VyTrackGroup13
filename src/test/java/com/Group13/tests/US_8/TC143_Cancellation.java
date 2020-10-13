package com.Group13.tests.US_8;

import com.Group13.pages.*;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC143_Cancellation extends TestBase {

    @Test
     public void TC143() {

        extentLogger = report.createTest("TC 143");

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();
        BrowserUtils.clickWithJS(allVehicleContractPage.createVehicleContract);


        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        BrowserUtils.clickWithJS(createVehicleContractPage.cancelButton);

        extentLogger.info("Cancellation of Contract");
        Assert.assertEquals(allVehicleContractPage.pageSubTitle.getText(),"Vehicle Contract");



        BrowserUtils.waitFor(3);
        extentLogger.pass("PASS");



    }

}
