package com.Group13.tests.US_8;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_1_AccessVehicleContractPage extends TestBase {

    /*VERIFY VEHICLE CONTRATS ON THE GRID
    Open browser
    Login as salesmanager
    Go to 'Dashboard View' page
    Move on the  'Fleet' module
    Click on 'Vehicle Contracts' option
    Verify that page subtitle is Quick Launchpad
    * */

    @Test
    public void VehicleContractPage(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();


        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        String expectedSubtitle = "All Vehicle Contract";
        String actualpageSubTitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualpageSubTitle,expectedSubtitle,"verify the subtitle");


    }

















}
