package com.Group13.tests.HomeWork;

import com.Group13.pages.CalendarEventsPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC_4 extends TestBase {
    @DataProvider
    public Object[][] data(){

        String [][] login = {{"storemanager85", "UserUser123"}};

        return login;
    }
    @Test(dataProvider = "data")
    public void test4(String username,String password){

        extentLogger = report.createTest("TestCase-4, Verify number of records");

        //goto qa1
        //login as store manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        //navigate to calender events
        extentLogger.info("Navigate to Calender Events");
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        //(TC-4)
        extentLogger.info("verify that number of calendar events is equals to number of records");

        BrowserUtils.clickWithJS(calendarEventsPage.dataSize100);
        BrowserUtils.waitFor(2);
        List<WebElement> allrows = calendarEventsPage.row;

        String textofPageNumber = calendarEventsPage.totalPageNumber.getText();
        String[] arrayOfPageNumber = textofPageNumber.split(" ");
        System.out.println(Arrays.toString(arrayOfPageNumber));
        int justNumberOfPage = Integer.parseInt(arrayOfPageNumber[1])-1;
        int sizeOfRows=0;
        int totalSizeOfRows=0;

        for (int i = 0; i <= justNumberOfPage; i++) {
            sizeOfRows= allrows.size();
            totalSizeOfRows+=sizeOfRows;

            BrowserUtils.clickWithJS(calendarEventsPage.rightArrow);
            BrowserUtils.waitFor(2);

        }

        System.out.println(totalSizeOfRows);
        String str = String.valueOf(totalSizeOfRows);
        Assert.assertEquals(str,"1732", "verify number of records");

        extentLogger.pass("PASS");

    }
}
