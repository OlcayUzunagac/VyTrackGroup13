package com.Group13.tests.US_12;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC_116 extends TestBase {
    //US-12- Test Case - 116 ----->2.Verify that truck driver should be able to create Vehicle service logs or cancel it
    @Test
    public void VytrackTC116() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        DashboardPage dashboardPage = new DashboardPage();

        dashboardPage.navigateToModule("Fleet", "Vehicle Services Logs");
        Thread.sleep(5000);
        //driver.findElement(By.partialLinkText("Create")).click();

        BrowserUtils.waitFor(4);
        BrowserUtils.hoverClick(driver.findElement(By.xpath("//div/a[@title='Create Vehicle Services Logs']")));
    }
}