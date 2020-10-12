package com.Group13.pages;

import com.Group13.utilities.ConfigurationReader;
import com.Group13.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    //driver.findElement(By.id("prependedInput"));
    @FindBy(name = "_username")
    public WebElement usernameInput;

    /*@FindAll({//asagidakilerden bi tanesi dogruysa, return that webelement
            @FindBy(id = "pretendedInput"),
            @FindBy(name = "username")
    })
    */
    /*@FindBys({//asagidakilerden her ikiside dogruysa, return that webelement
                //bi tanesini bulamassa calismaz
            @FindBy(id = "pretendedInput"),
            @FindBy(name = "username")
    })
    */


    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")//driver.findElement(By.id("_submit));-->2 satirin yaptigi is budur.
    public WebElement loginBtn;



    //login methods;

    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsdriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsSalesManager(){

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }





    //bütün kullanicilar icin bir method olusturup, switch case ile ortak bir mekrzde toplama isine calis.

}