package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TableUtils {
    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verifyOrderin TableUtilsclass.
    // •Methodtakes WebDriver object and String(name).
    // •Methodshould verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    public static void verifyOrder(WebDriver driver, String name){
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));


        //to introduce local variable: Alt+Enter
        for (WebElement each : allNames) {
            //System.out.println(each.getText());
            if(each.getText().equals(name)){
                Assert.assertTrue(true);
                return;//exits the method()
            }
        }
        //Assert.fail("any error message goes here. It will fail the code") - will fail the test and not continue execution
        Assert.assertTrue(false, "Name does not exist in the list");
    }
    //Practice #5:
    // Method: printNamesAndEmails
    // •Create a method named print Names And  Emails  in TableUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names and emails in the table
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , Email1: email
    // •Name2: name , Email2: email

    public static void printNamesAndEmails(WebDriver driver){
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='table1']//tr/td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//table[@id='table1']//tr/td[3]"));
        for (int i = 0, j=0; i < allNames.size(); i++, j++) {
            System.out.println("Name" + (i+1) + ": "+allNames.get(i).getText()+", Email" + (j+1) + ": " + allEmails.get(j).getText());
        }
    }
}
