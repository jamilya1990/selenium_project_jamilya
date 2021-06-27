package com.cybertek.practice_tasks.day12_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop {
    //TC #16: Hover Test
    @Test
    public void dragAndDrop(){
    // 1.Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get(ConfigurationReader.getProperty("dragDropURL"));
    // 2.Drag and drop the small circle to bigger circle.
        WebElement circleToDrag = Driver.getDriver().findElement(By.id("draggable"));
        WebElement circleToDrop = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(circleToDrag, circleToDrop).perform();

    // 3.Assert: -Text in big circle changed to: “You did great!”
        WebElement textToValidate = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));
        Assert.assertTrue(textToValidate.isDisplayed());
    }
}
