package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
    Method that accepts int
    and Wait for given second duration
    */
    public static void sleep(WebDriver driver, int seconds){
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void sleep(int seconds) {
        seconds*=1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Jamilya, something happened in the sleep method");
        }
    }





}
