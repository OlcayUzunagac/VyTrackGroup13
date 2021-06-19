package com.Group13.tests.US_12;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.Group13.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_116 extends TestBase {
    //US-12- Test Case -
    // 116 ----->2.Verify that truck driver should be able to create Vehicle service logs or cancel it
    @Test
    public void VytrackTC116() throws InterruptedException {
        extentLogger = report.createTest("Truck driver creates Vehicle Service logs");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as a Truck driver");
        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet > Vehicles Services Logs");

        dashboardPage.navigateToModule("Fleet", "Vehicle Services Logs");

        BrowserUtils.waitFor(4);
        BrowserUtils.hoverClick(driver.findElement(By.xpath("//div/a[@title='Create Vehicle Services Logs']")));
        Thread.sleep(3000);

        Select menuselect = new Select(Driver.get().findElement(By.id("custom_entity_type_ServiceType-uid-5f917ba7b6228")));
        menuselect.selectByVisibleText("Road Assistance");
        // driver.findElement(By.id("submit")).click();

       // totalprice.sendKeys("15000");
    }
}