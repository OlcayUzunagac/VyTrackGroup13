package com.Group13.tests.US_6;

import com.Group13.pages.AllVehicleCost;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class TC_2 extends TestBase {
    //2. Verify that Store manager or sales manager should be able to create Vehicle
    //cost or cancel it
    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicle Costs");

        AllVehicleCost vehicleCost = new AllVehicleCost();
        BrowserUtils.waitFor(3);
        vehicleCost.CreateVehicleCost.click();

        BrowserUtils.waitFor(3);
        vehicleCost.cancel.click();

    }
}
