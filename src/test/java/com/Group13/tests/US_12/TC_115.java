package com.Group13.tests.US_12;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class TC_115 {
    //US-12- Test Case - 115 -----> 1.Verify that truck driver should be able to see all Vehicle service logs


    @Test
    public void VytrackTC115() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Fleet", "Vehicle Services Logs");


        Thread.sleep(15000);
    }
}