package com.Group13.tests.US_8;

import com.Group13.pages.*;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC_144_146_EditingVehicleContract extends TestBase {

    @Test
    public void TC144() {

        extentLogger = report.createTest("TestCase144");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        BrowserUtils.waitFor(2);
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");

        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();
        BrowserUtils.waitFor(2);

        String numberOfPage = allVehicleContractPage.numberOfPage.getText();
        String [] pagenumber = numberOfPage.split(" ");
        int number = Integer.parseInt(pagenumber[1]);

        extentLogger.info("Click the next Button 'number of page -1' times");
        for (int i = 1; i < number ; i++) {
            BrowserUtils.clickWithJS(allVehicleContractPage.nextButton);
        }

        allVehicleContractPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.hover(allVehicleContractPage.threepoint);
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(allVehicleContractPage.editIcon);

        CreateVehicleContractPage createVehicleContractPage = new CreateVehicleContractPage();
        createVehicleContractPage.responsible.clear();
        createVehicleContractPage.responsible.sendKeys("Schumaher");

        BrowserUtils.clickWithJS(createVehicleContractPage.saveAndCloseButton);

        ContractInfoPage contractInfoPage = new ContractInfoPage();
        BrowserUtils.waitFor(2);
        String header = "Schumaher";
        BrowserUtils.waitFor(2);

        Assert.assertTrue(contractInfoPage.getHeaderOfContract(header).getText().contains("Schumaher"));
        Assert.assertEquals(contractInfoPage.nameOfResponsible.getText(),"Schumaher");


    }

}
