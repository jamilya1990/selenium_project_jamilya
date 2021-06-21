package com.cybertek.tests.day12_actions_upload_jsexecuter;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverUtilPractice {


    @Test
    public void simple_google_search_test(){

        //1- go to google.com

        //Driver.getDriver() = driver --> create driver instance and ready to use
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));
        //2 - search for value
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));

        String searchValue = ConfigurationReader.getProperty("searchValue");
        searchBox.sendKeys(searchValue+Keys.ENTER);

        //3 - Verify the title contains google
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
//This will terminate the session and assign driver to null
        Driver.closeDriver();

        Driver.getDriver().get("https://etsy.com");


    }
}
