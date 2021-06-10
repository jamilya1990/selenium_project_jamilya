package com.cybertek.practice_tasks.day10_practice_tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SmartBearUtilsClass {
    // •Create a method named verifyOrder in SmartBearUtils class.
    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.

    public static void verifyOrder(WebDriver driver, String name){
        List<String> list = new ArrayList<>();
        int countOfNames = 0;
        for (String each : list) {
            if(each.equals(name)){
                countOfNames++;
            }
        }
        Assert.assertFalse(countOfNames>1, "word " +name+" is not in the list");
    }

    public static void printNamesAndCities(WebDriver driver){
        List<WebElement> list = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Name"+i + ""+ list.get(i));
        }
    }
}
