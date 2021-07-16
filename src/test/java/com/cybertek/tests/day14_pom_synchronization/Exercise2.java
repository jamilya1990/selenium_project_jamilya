package com.cybertek.tests.day14_pom_synchronization;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise2 {
    @BeforeMethod
    public void openSite(){
        Driver.getDriver().get("http://te.dev.secureci.com/Exercise2.html");

    }

    @Test
    public void Test() throws InterruptedException {
        List<WebElement> list =Driver.getDriver().findElements(By.xpath("//div[@class='slider round']"));
        for (WebElement webElement : list) {
            webElement.click();
            Thread.sleep(2);
        }

    }
}
