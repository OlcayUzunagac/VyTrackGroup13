package com.Group13.tests.US_13;


import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.pages.VehiclesModelPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.Group13.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_13 extends TestBase {

    /*VERIFY Store Manager able to see Vehicle Model Page
    Open browser
    Login as Store manager
    Go to Fleet -> Vehicles Model
    Verify that user could able to see Web Element with the text All Vehicles Model
    * */

    @Test
    public void test170(){
        extentLogger = report.createTest("Store Manager could able to see Vehicles Model");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a Store Manager");
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to --> Fleet > Vehicles Model");
        dashboardPage.navigateToModule("Fleet","Vehicles Model");

        VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

        extentLogger.info("Verify Current Url is " + "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel");
        String actualCurrentUrl = Driver.get().getCurrentUrl();
        String expectedCurrentUrl = "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel";

        Assert.assertEquals(actualCurrentUrl,expectedCurrentUrl,"Verify Store manager could able to see Vehicles Model page");

        extentLogger.pass("PASSED");

    }


    /*VERIFY Sales Manager able to see Vehicle Model Page
        Open browser
        Login as Sales manager
        Go to Fleet -> Vehicles Model
        Verify that user could able to see Web Element with the text All Vehicles Model
        * */
    @Test
    public void test171(){
        extentLogger = report.createTest("Sales Manager could able to see Vehicles Model");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a Sales Manager");
        loginPage.loginAsSalesManager();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to --> Fleet > Vehicles Model");
        dashboardPage.navigateToModule("Fleet","Vehicles Model");

        VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

        extentLogger.info("Verify Current Url is " + "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel");
        String actualCurrentUrl = Driver.get().getCurrentUrl();
        String expectedCurrentUrl = "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel";

        Assert.assertEquals(actualCurrentUrl,expectedCurrentUrl,"Verify Sales manager could able to see Vehicles Model page");

        extentLogger.pass("PASSED");
    }


    /*VERIFY Truck driver not able to see Vehicle Model Page
        Open browser
        Login as Sales manager
        Go to Fleet -> Vehicles Model
        Verify that user could not able to see Web Element with the text All Vehicles Model
        * */
    @Test
    public void test172(){
        extentLogger = report.createTest("Truck driver could not able to see Vehicles Model");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Login as a Truck driver");
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to --> Fleet > Vehicles Model");
        dashboardPage.navigateToModule("Fleet","Vehicles Model");

        VehiclesModelPage vehiclesModelPage = new VehiclesModelPage();

        BrowserUtils.waitFor(5);

        extentLogger.info("Verify Current Url is " + "https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel");

        String actualCurrentUrl = Driver.get().getCurrentUrl();
        Assert.assertFalse(actualCurrentUrl.equals("https://qa2.vytrack.com/entity/Extend_Entity_VehiclesModel"));

        extentLogger.pass("PASSED");

    }





}
