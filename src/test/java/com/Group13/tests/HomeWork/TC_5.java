package com.Group13.tests.HomeWork;

import com.Group13.pages.CalendarEventsPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_5 extends TestBase {


    @Test
    public void test5(){
        extentLogger = report.createTest("TestCase-5");

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        extentLogger.info("Click on the top checkbox to select all");
        BrowserUtils.clickWithJS(calendarEventsPage.checkBox);
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify all calendar events selected");
        for (int i = 1; i <= calendarEventsPage.row.size(); i++) {
            String str = String.valueOf(i);
            Assert.assertTrue(calendarEventsPage.setRowsCheckBox(str).isDisplayed());
        }

        extentLogger.pass("PASS");

    }
}
