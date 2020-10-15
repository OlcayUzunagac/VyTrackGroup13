package com.Group13.tests.US_8;

import com.Group13.pages.AllVehicleContractPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class TC_148_MoreActionOnVehicleContract extends TestBase {

    @Test
    public void testCase_148(){

        extentLogger = report.createTest("Test Case 148, make more action on Vehicle Contract");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");
        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();
        BrowserUtils.waitFor(3);
        allVehicleContractPage.firstLine.click();











    }
}
