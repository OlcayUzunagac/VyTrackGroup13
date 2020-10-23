package com.Group13.tests.US_7;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.Group13.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends TestBase {

    @Test
    public void TC2(){
        //2.Verify that Non authorized user should not be able to access Vehicle Contract
         //       (Note: Truck driver)

        //Open browser,Login as salesmanager
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");
        BrowserUtils.waitForPageToLoad(3);
        Assert.assertNotEquals(dashboardPage.getPageSubTitle(),"All Vehicle Contract");
        System.out.println("dashboardPage.getPageSubTitle() = " + dashboardPage.getPageSubTitle());



    }

}
