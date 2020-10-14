package com.Group13.tests.US_9;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.pages.VehicleFuelLogsPage;
import com.Group13.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_9 extends TestBase {

    /*VERIFY Driver able to see Vehicle Fuel Logs
    Open browser
    Login as driver
    Go to Fleet -> Fleet Fuel Logs
    Verify that user could able to see Web Element with the text Vehicle Fuel Logs
    * */

    @Test
    public void test161(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicles Fuel Logs");

        VehicleFuelLogsPage vehicleFuelLogsPage = new VehicleFuelLogsPage();
        String actualSubtitle = vehicleFuelLogsPage.getPageSubTitle();
        String expectedSubtitle = "Vehicle Fuel Logs";

        Assert.assertEquals(actualSubtitle,expectedSubtitle,"Verify that Web Element with the text Vehicle Fuel Logs");
    }


    /*VERIFY Store manager should not be able to access Vehicle Fuel Logs
    Open browser
    Login as driver
    Go to Fleet -> Fleet Fuel Logs
    Verify that store manager must see "You do not have permission to perform this action"
    * */
    @Test
    public void test162(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicles Fuel Logs");

        String actualMessage = dashboardPage.permissionMessage.getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that the message \"You do not have permission to perform this action\" ");
    }


    /*VERIFY Sales manager should not be able to access Vehicle Fuel Logs
    Open browser
    Login as driver
    Go to Fleet -> Fleet Fuel Logs
    Verify that sales manager must see "You do not have permission to perform this action"
    * */
    @Test
    public void test163(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicles Fuel Logs");

        String actualMessage = dashboardPage.permissionMessage.getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualMessage,expectedMessage,"Verify that the message \"You do not have permission to perform this action\" ");
    }

}
