package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.tests.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TableTask3 extends TestBase {
    @Test
    //1.	Open browser and go to: http://practice.cybertekschool.com/tables#edit
    //2.	Locate first table and verify Tim has due amount of “$50”
    //
    //Note: Create locator for Tim that will be dynamic and doesn’t care in which row Tim is.
    public void webTableOrderVerification(){
        //OR
        //String url = ConfigurationReader.getProperty("dataTableURL");
        driver.get(ConfigurationReader.getProperty("dataTableURL"));

        WebElement timsDueAmount = driver.findElement(By.xpath("//table[@id='table1']//tr/td[.='Tim']/following-sibling::td[2]"));
        // //table[@id='table1']//tr/td[.='Tim']/../td[4]
        // //table[@id='table1']//tr/td[.='Tim']/following-sibling::td[2]

        Assert.assertEquals(timsDueAmount.getText(),"$50.00");
        BrowserUtils.sleep(3);
    }
    @Test
    public void task4_verify_order_method(){
        driver.get(ConfigurationReader.getProperty("dataTableURL"));

        TableUtils.verifyOrder(driver,"Tim");

    }
    @Test
    public void task5_printAllNamesEmails(){
        driver.get(ConfigurationReader.getProperty("dataTableURL"));

        TableUtils.printNamesAndEmails(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
