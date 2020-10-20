package com.Group13.tests.US_1;

import com.Group13.pages.DashboardPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import com.Group13.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class TestCase extends TestBase {

    String dummyString = "Cybertek";

    @Test
    public void EUG13_111() {

        extentLogger = report.createTest("Navigation to Vehicle");

        //Verify that truck driver should be able to see all Vehicle information once navigate to Vehicle page.
        extentLogger.info("username: "+ ConfigurationReader.get("driver_username"));
        extentLogger.info("password: "+ConfigurationReader.get("driver_password"));
        extentLogger.info("Login as Driver");
        DashboardPage dashBoard = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet --> Vehicles");
        dashBoard.navigateToModule("Fleet", "Vehicles");
        extentLogger.pass("PASSED");
        dashBoard.logOut();



    }

    @Test
    public void EUG13_152() throws InterruptedException {

        extentLogger = report.createTest("Navigation to Vehicle");

        //Verify that user can see general information by clicking any car
        extentLogger.info("username: "+ConfigurationReader.get("driver_username"));
        extentLogger.info("password: "+ConfigurationReader.get("driver_password"));
        extentLogger.info("Login as Driver");
        DashboardPage dashBoard = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet --> Vehicles");
        dashBoard.navigateToModule("Fleet", "Vehicles");

        Random rn = new Random();
        int indexNum = rn.nextInt(23) +1;
        System.out.println(indexNum);

        String expected = driver.findElement(By.xpath("(//td[@data-column-label='Driver'])"+"["+indexNum+"]")).getText();
        Thread.sleep(2000);
        WebElement hoverCar = driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action'])"+"["+indexNum+"]"));
        BrowserUtils.waitFor(2);
        extentLogger.info("Driver hover on and click on any car on the grid");
        BrowserUtils.hoverClick(hoverCar);
        Thread.sleep(2000);

        String actual = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();
        Assert.assertTrue(actual.contains(expected),"Verify driver name is contain");
        extentLogger.pass("PASSED");
        Thread.sleep(1000);
        dashBoard.logOut();



    }
    @Test
    public void EUG13_160() throws InterruptedException {

        extentLogger = report.createTest("Navigation to Vehicle");

        //Verify user can add Event and it should display under Activity tab and General information page.
        extentLogger.info("username: "+ConfigurationReader.get("driver_username"));
        extentLogger.info("password: "+ConfigurationReader.get("driver_password"));
        extentLogger.info("Login as Driver");
        DashboardPage dashBoard = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet --> Vehicles");
        dashBoard.navigateToModule("Fleet", "Vehicles");

        Random rn = new Random();
        int indexNum = rn.nextInt(23) +1;
        System.out.println(indexNum);

        WebElement hoverCar = driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action'])"+"["+indexNum+"]"));
        BrowserUtils.waitFor(2);
        extentLogger.info("Driver hover on and click on any car on the grid");
        BrowserUtils.hoverClick(hoverCar);
        Thread.sleep(2000);
        BrowserUtils.hoverClick(driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']")));
        extentLogger.info("Verify user can add Event and it should display under Activity tab and General information page.");
        BrowserUtils.waitFor(3);
        extentLogger.info("Add event");
        driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']")).sendKeys(dummyString);
        BrowserUtils.waitFor(1);
        extentLogger.info("After adding save the addition");
        driver.findElement(By.xpath("//button[.='Save']")).click();
        extentLogger.info("Driver should display changes under Activity tab and General information page");
        String actual = driver.findElement(By.xpath("//*[.='"+dummyString+"']")).getText().trim();
        Assert.assertEquals(actual, dummyString,"Verify both are same");

        extentLogger.pass("PASSED");
        dashBoard.logOut();

    }

    @Test
    public void EUG13_165() throws InterruptedException {

        extentLogger = report.createTest("Navigation to Vehicle");

        //Verify that Truck driver can reset the setting
        extentLogger.info("username: "+ConfigurationReader.get("driver_username"));
        extentLogger.info("password: "+ConfigurationReader.get("driver_password"));
        extentLogger.info("Login as Driver");
        DashboardPage dashBoard = new DashboardPage();

        extentLogger.info("Navigate to --> Fleet --> Vehicles");
        dashBoard.navigateToModule("Fleet", "Vehicles");

        Random rn = new Random();
        int indexNum = rn.nextInt(23) +1;
        System.out.println(indexNum);

        WebElement hoverCar = driver.findElement(By.xpath("(//tr[@class='grid-row row-click-action'])"+"["+indexNum+"]"));
        BrowserUtils.waitFor(3);

        extentLogger.info("Driver hover on and click on any car on the grid");
        BrowserUtils.hoverClick(hoverCar);
        Thread.sleep(2000);
        BrowserUtils.hoverClick(driver.findElement(By.xpath("//div[@class='pull-left btn-group icons-holder']")));

        extentLogger.info("Verify user can add Event and it should display under Activity tab and General information page.");
        BrowserUtils.waitFor(3);

        extentLogger.info("Add event");
        driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']")).sendKeys(dummyString);
        BrowserUtils.waitFor(1);

        extentLogger.info("After adding save the addition");
        driver.findElement(By.xpath("//button[.='Save']")).click();

        extentLogger.info("Driver should display changes under Activity tab and General information page");

        extentLogger.info("Hover on");
        BrowserUtils.hover(driver.findElement(By.xpath("//*[@class='dropdown vertical-actions activity-actions']")));

        extentLogger.info("Verify that Truck driver can reset the setting");
        BrowserUtils.hoverClick(driver.findElement(By.xpath("//*[@title='Update Calendar event']")));
        String expected = "Widget content loading failed";
        String actual = driver.findElement(By.xpath("//div[.='Widget content loading failed'][@class='alert alert-error']")).getText().trim();
        Assert.assertFalse(true, actual);

        extentLogger.pass("PASSED");
        dashBoard.logOut();

    }
}
