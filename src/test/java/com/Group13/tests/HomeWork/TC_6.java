package com.Group13.tests.HomeWork;

import com.Group13.pages.CalendarEventsInfoPage;
import com.Group13.pages.CalendarEventsPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_6 extends TestBase {

    @Test
    public void test6() throws IOException {

        extentLogger = report.createTest("TestCase-6");
        //goto qa1
        //login as store manager
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85", "UserUser123");
        DashboardPage dashboardPage = new DashboardPage();
        //navigate to calender events
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        BrowserUtils.waitFor(2);

        //TC-6

        extentLogger.info("Select Testers Meeting");
        calendarEventsPage.getFirstRow("Testers meeting").click();
        extentLogger.info("Verify the given data is displayed");
        CalendarEventsInfoPage calendarEventsInfoPage = new CalendarEventsInfoPage();
        Assert.assertEquals(calendarEventsInfoPage.getTitle("Testers meeting").getText(),"Testers meeting");
        Assert.assertEquals(calendarEventsInfoPage.getDescription("This is a a weekly testers meeting").getText(),"This is a a weekly testers meeting");
        Assert.assertEquals(calendarEventsInfoPage.getStart("Nov 27, 2019, 9:30 PM").getText(),"Nov 27, 2019, 9:30 PM");
        Assert.assertEquals(calendarEventsInfoPage.getStart("Nov 27, 2019, 10:30 PM").getText(),"Nov 27, 2019, 10:30 PM");
        Assert.assertEquals(calendarEventsInfoPage.allDayEvent.getText(),"No");
        Assert.assertEquals(calendarEventsInfoPage.organizer.getText(),"Stephan Haley");
        Assert.assertEquals(calendarEventsInfoPage.guests.getText(),"Tom Smith");
        Assert.assertEquals(calendarEventsInfoPage.recurrence.getText(),"Weekly every 1 week on Wednesday");
        Assert.assertEquals(calendarEventsInfoPage.callViaHangout.getText(),"No");

        extentLogger.pass("PASS");

    }
}
