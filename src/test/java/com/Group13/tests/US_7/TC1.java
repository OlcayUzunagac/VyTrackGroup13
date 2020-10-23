package com.Group13.tests.US_7;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends TestBase {



    @Test
    public void AuthorizedUserAccessVehicleContract(){

        //1.Verify that Only authorized user should be able to access Vehicle Contract.
       // (Note: authorized users: store manager, sales manager)

        //Open browser,Login as salesmanager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertEquals(dashboardPage.getPageSubTitle(),"All Vehicle Contract");
        System.out.println("dashboardPage.getPageSubTitle() = " + dashboardPage.getPageSubTitle());


    }




}
