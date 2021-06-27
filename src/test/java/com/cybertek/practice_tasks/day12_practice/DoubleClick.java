package com.cybertek.practice_tasks.day12_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {
    //TC #16: Double ClickTest

    @Test
    public void doubleClick(){
    // 1.Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get(ConfigurationReader.getProperty("w3schoolURL"));
    // 2.Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");
    // 3.Double click on the text “Double-click me to change my text color.”
        WebElement textToClick = Driver.getDriver().findElement(By.id("demo"));
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(textToClick).perform();
    // 4.Assert: Text’s “style” attribute value contains “red”.
        String red = textToClick.getAttribute("style");
        Assert.assertTrue(red.contains("red"));
    }
}
