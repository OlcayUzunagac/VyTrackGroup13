package com.Group13.tests.US_8;

import com.Group13.pages.DashboardPage;
import com.Group13.pages.LoginPage;
import com.Group13.tests.TestBase;
import com.Group13.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class TC_2_CreationOfVehicleContract extends TestBase {



    @Test
    public void CreatVehicleContract() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsSalesManager();

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Fleet","Vehicle Contracts");

        WebElement element = driver.findElement(By.xpath("//a[@title='Create Vehicle Contract']"));
        BrowserUtils.clickWithJS(element);

        Thread.sleep(4000);
        WebElement typesOptions = driver.findElement(By.cssSelector("div[id^='s2id_custom_entity_type_Type-']"));
        BrowserUtils.clickWithJS(typesOptions);



        //BrowserUtils.getElementsText(typesOptions);
        System.out.println(typesOptions);
















    }









}
