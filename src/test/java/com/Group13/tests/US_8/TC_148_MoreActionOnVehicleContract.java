package com.Group13.tests.US_8;

import com.Group13.pages.AllVehicleContractPage;
import com.Group13.pages.ContractInfoPage;
import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_148_MoreActionOnVehicleContract extends TestBase {

    @Test
    public void testCase_148(){

        extentLogger = report.createTest("Test Case 148, make more action on Vehicle Contract");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet", "Vehicle Contracts");
        AllVehicleContractPage allVehicleContractPage = new AllVehicleContractPage();
        BrowserUtils.waitFor(3);
        allVehicleContractPage.firstLine.click();

        extentLogger = report.createTest("Click more actions button and see the other options");
        ContractInfoPage contractInfoPage = new ContractInfoPage();
        BrowserUtils.waitFor(3);
        contractInfoPage.moreActions.click();
        String addAttachmentText = contractInfoPage.addAttachment.getText();
        String addEventText = contractInfoPage.addEvent.getText();
        String addNoteText = contractInfoPage.addNote.getText();

        Assert.assertEquals(addAttachmentText,"Add Attachment");
        Assert.assertEquals(addEventText,"Add Event");
        Assert.assertEquals(addNoteText,"Add Note");

        contractInfoPage.addAttachment.click();
        BrowserUtils.waitFor(3);

        String projectPath = System.getProperty("user.dir");
        String filePath="src/test/resources/Vehicle Contract.png";
        String fullPath=projectPath+filePath;

        contractInfoPage.chooseFile.click();
        contractInfoPage.chooseFile.sendKeys(fullPath);








    }
}
