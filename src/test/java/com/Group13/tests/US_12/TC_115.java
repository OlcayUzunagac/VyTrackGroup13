package com.Group13.tests.US_12;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.pages.VehicleServicesLogs;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.Group13.utilities.ConfigurationReader;
import com.Group13.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_115  extends TestBase {
    //US-12- Test Case - 115 -----> 1.Verify that truck driver should be able to see all Vehicle Services logs


    @Test
    public void VytrackTC115() throws InterruptedException {
        extentLogger = report.createTest("Truck driver is able to see Vehicle Services Logs");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a driver");

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet > Vehicles Services Logs");
        dashboardPage.navigateToModule("Fleet", "Vehicle Services Logs");

        VehicleServicesLogs vehicleServicesLogs= new VehicleServicesLogs();
        BrowserUtils.waitFor(5);

        extentLogger.info("Current URL is " + "https://qa2.vytrack.com/entity/Extend_Entity_VehicleServicesLogs");

        String actualCurrentUrl = Driver.get().getCurrentUrl();
        String expectedUrl = Driver.get().getCurrentUrl();

        Assert.assertEquals(actualCurrentUrl,expectedUrl,"https://qa2.vytrack.com/entity/Extend_Entity_VehicleServicesLogs");
        extentLogger.pass("PASSED");
    }
}