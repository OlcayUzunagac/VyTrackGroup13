package com.Group13.tests.US_6;

import com.Group13.pages.AllVehicleCost;
import com.Group13.pages.CreateVehicleCost;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_3 extends TestBase {
    //3.Verify that store manager or sales manager should be able to delete or edit the costs
    @Test
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule("Fleet","Vehicle Costs");

        AllVehicleCost vehicleCost = new AllVehicleCost();
        dashboardPage.waitUntilLoaderScreenDisappear();
        Thread.sleep(2000);
        vehicleCost.CreateVehicleCost.click();

        CreateVehicleCost createVehicleCost = new CreateVehicleCost();
        dashboardPage.waitUntilLoaderScreenDisappear();
        createVehicleCost.Type.click();
        System.out.println("createVehicleCost.Type.getText() = " + createVehicleCost.Type.getText());
        createVehicleCost.taxRoll.click();
        BrowserUtils.waitFor(2);
        //Select s = new Select(createVehicleCost.Textarea);
        // s.selectByIndex(3);

        createVehicleCost.SaveAndCloseButton.click();


        dashboardPage.waitUntilLoaderScreenDisappear();
        createVehicleCost.Edit.click();

        dashboardPage.waitUntilLoaderScreenDisappear();
        createVehicleCost.Delete.click();

        String expectedResult ="Delete Confirmation";
        String accptedResult = createVehicleCost.DeleteConfirmation.getText();
        Assert.assertEquals(accptedResult,expectedResult);


    }
}
