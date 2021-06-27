package com.cybertek.practice_tasks.day12_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {
    //TC #17: Context Click –HOMEWORK


    @Test
    public void contextClick(){
    // 1.Go to https://the-internet.herokuapp.com/context_menu
        Driver.getDriver().get(ConfigurationReader.getProperty("contextMenuURL"));
    // 2.Right click to the box.
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(box).perform();
    // 3.Alert will open.
        // 4.Accept alert
        Driver.getDriver().switchTo().alert().accept();

        // No assertion needed for this practice.

    }
}
