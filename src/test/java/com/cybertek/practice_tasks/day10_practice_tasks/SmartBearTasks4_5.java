package com.cybertek.practice_tasks.day10_practice_tasks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartBearTasks4_5 {
    WebDriver driver;
    @Test
    public void smartBear(){
        //PRACTICE #4:
        // Method: verifyOrder
        // •Create a method named verifyOrder in SmartBearUtils class.
        // •Method takes WebDriver object and String(name).
        // •Method should verify if given name exists in orders.
        // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
        // •Create a new TestNG test to test if the method is working as expected.
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("Java", "Jami", "Doc", "Baby"));
        String name = "Baby";
        SmartBearUtilsClass.verifyOrder(driver, name);
    }

}
