package com.cybertek.tests.day8_windows_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SwitchToSecondWindow {
    WebDriver driver;

    @BeforeMethod

    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }

    @Test
    public void multipleWindowsTest() {
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        List<WebElement> windows = new ArrayList<>();

        for (String windowHandle : driver.getWindowHandles()) {

        }
    }
}
