package com.cybertek.tests.day12_actions_upload_jsexecuter;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorPractice {
    @Test
    public void scroll_using_JSExecuter_test1(){
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //Downcasting our driver type to JS Executor, so we can reach methods(functions) in this test
       JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
       //another way
       // (JavascriptExecutor) ((JavascriptExecutor) Driver.getDriver()).executeScript();

        //using js we reach executeScript method so we are allowed to pass JavaScript functions
        //this method is capable of accepting JavaScript functions and apply that onto Java+Selenium code
        js.executeScript("window.scrollBy(0,750)");//(x, y) - scroll down 750 pxls and 0 scrolls to the side

        for (int i = 0; i <10 ; i++) {
            js.executeScript("window.scrollBy(0, 300)");
        }
        js.executeScript("window.scrollBy(0, -400)");

    }
    @Test
    public void scroll_using_JSExecuter_test2() {
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //Downcasting our driver type to JS Executor, so we can reach methods(functions) in this test
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement cybertekSchooleLink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //JS executor with different scrolling JavaScript function

        js.executeScript("arguments[0].scrollIntoView(true)", cybertekSchooleLink);

        //scroll back up to Home link
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink);


    }
}
