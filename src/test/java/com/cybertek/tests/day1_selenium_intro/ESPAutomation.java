package com.cybertek.tests.day1_selenium_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ESPAutomation {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://ut2.etimesheets.ihss.ca.gov/login");
    }

    @Test
    public void loginPageESP(){

        driver.findElement(By.id("username")).sendKeys("veronica2025");
        driver.findElement(By.id("pwd")).sendKeys("Password12");
        driver.findElement(By.xpath("//span[.='Login']")).click();
    }
}
