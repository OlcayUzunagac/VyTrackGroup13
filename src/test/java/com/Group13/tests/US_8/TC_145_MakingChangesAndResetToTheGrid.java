package com.Group13.tests.US_8;

import com.Group13.pages.AllVehicleContractPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_145_MakingChangesAndResetToTheGrid extends TestBase {

    @Test
    public void TC145(){

        extentLogger = report.createTest("Reset to the Vehicle Contract");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");
        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();

        BrowserUtils.clickWithJS(allVehicleContractPage.dataSize100);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(allVehicleContractPage.settingButton);
        BrowserUtils.clickWithJS(allVehicleContractPage.checkboxActivationCost);
        BrowserUtils.clickWithJS(allVehicleContractPage.checkboxResponsible);
        BrowserUtils.waitFor(2);

        BrowserUtils.clickWithJS(allVehicleContractPage.reset);

        BrowserUtils.clickWithJS(allVehicleContractPage.settingButton);

        BrowserUtils.waitFor(2);
        Assert.assertTrue(allVehicleContractPage.responsibleChecked.isSelected());
        Assert.assertTrue(allVehicleContractPage.activationCostChecked.isSelected());
        Assert.assertFalse(allVehicleContractPage.idChecked.isSelected());

        BrowserUtils.waitFor(3);
        extentLogger.pass("PASS");

    }

}
