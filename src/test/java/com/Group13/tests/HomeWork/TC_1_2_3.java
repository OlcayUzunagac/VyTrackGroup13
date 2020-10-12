package com.Group13.tests.HomeWork;

import com.Group13.pages.CalendarEventsPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TC_1_2_3 extends TestBase {

    @DataProvider
    public Object[][] data(){

        String [][] login= {{"storemanager85", "UserUser123"}};

        return login;
    }


    @Test(dataProvider = "data")
    public void test1_2_3(String username, String password){

        extentLogger = report.createTest("TestCase-1,2,3 ");

        //goto qa1
        //login as store manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);


        extentLogger.info("Navigate to Calender Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //(TC-1)
        extentLogger.info("Verify that Options is displayed");
        Assert.assertTrue(calendarEventsPage.options.isDisplayed(),"verify options is displayed");

        //(TC-2)
        extentLogger.info("Verify that pagenumber is '1'");
        Assert.assertEquals(calendarEventsPage.pageNumber.getAttribute("value"),"1","verify page number");

        //(TC-3)
        extentLogger.info("verify that view per page number is equals to '25'");
        Assert.assertEquals(calendarEventsPage.viewPerPage.getText(),"25", "verify view per Page is '25'");

        extentLogger.pass("PASS");
        

    }
}
