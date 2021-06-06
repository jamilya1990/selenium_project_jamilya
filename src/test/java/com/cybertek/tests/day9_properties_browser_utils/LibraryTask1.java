package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.LibraryUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibraryTask1 {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://library2.cybertekschool.com/login.html");
//1.Open browser
// 2.Go to website: http://library2.cybertekschool.com/login.html
// 3.Enter username: “”
// 4.Enter password: “”
// 5.Click to Login button
// 6.Print out count of all the links on landing page
// 7.Print out each link text on this page
    }

    @Test
    public void loginLinkCountTest(){
        LibraryUtils.loginToLibrary(driver, "student13@library", "zcVbvUWH");

        //Assert.assertTrue(driver.getTitle().equals("Library"), "Actual Title "+driver.getTitle());
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText());
        }
    }
}
