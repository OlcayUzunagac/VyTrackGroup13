package com.Group13.tests.US_11;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_1 {
    //(US-11)Access vehicle service log by using Truck Driver's Credentials

    //TC --1. Verify that authorised user should be able to access and see all Vehicle service log
    //(Note: authorised: Truck driver)
    @Test
    public void VytrackTC107() throws InterruptedException {
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Fleet", "Vehicle Services Logs");

        Thread.sleep(15000);
    }

}



