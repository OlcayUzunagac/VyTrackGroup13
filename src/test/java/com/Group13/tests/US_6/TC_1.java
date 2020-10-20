package com.Group13.tests.US_6;

import com.Group13.pages.AllVehicleCost;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_1 extends TestBase {
    //Verfiy that store manager or Sales manager should be able to see all car's
    //cost inforamtions on the Vehicle Costs page
    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Fleet","Vehicle Costs");

        AllVehicleCost vehicleCost = new AllVehicleCost();
        System.out.println("vehicleCost.totalCost.size() = " + vehicleCost.totalCost.size());

        for (WebElement element : vehicleCost.totalCost) {
            System.out.println(element.getText());
            Assert.assertTrue(element.isDisplayed());
        }

    }
}
