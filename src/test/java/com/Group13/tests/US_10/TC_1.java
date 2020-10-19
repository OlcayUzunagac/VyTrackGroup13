package com.Group13.tests.US_10;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.pages.VehicleFuelLogsPage;
import com.Group13.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_1 extends TestBase {
    //login as driver
    //mouse hover over on top of fleet
    //click Vehicle Fuel Logs module
    //see the vehicle fuel logs grid

    @Test
    public void automationTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicles Fuel Logs");
        Thread.sleep(5000);

        VehicleFuelLogsPage vehicleFuelLogsPage = new VehicleFuelLogsPage();
        System.out.println(vehicleFuelLogsPage.getPageSubTitle());

        System.out.println("-----");

        System.out.println(vehicleFuelLogsPage.fuelLogInformation.getText());




        String actualSubtitle = vehicleFuelLogsPage.getPageSubTitle();
        String expectedSubtitle = "Vehicle Fuel Logs";
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify that Web Element with the text Vehicle Fuel Logs");




    }
}
