package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver) {

        //TC #1: Smartbear software link verification
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        // 3.Enter username: “Tester”
        // 4.Enter password: “test”
        // 5.Click to Login button
        // 6.Print out count of all the links on landing page
        // 7.Print out each link text on this page
        // Mini-Task:CREATE A CLASS à SmartBearUtils
        // •Create a method called loginToSmartBear
        // •This method simply logs in to SmartBear when you call it.
        // •Accepts WebDriver type as parameter
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Web Orders");

    }


}
