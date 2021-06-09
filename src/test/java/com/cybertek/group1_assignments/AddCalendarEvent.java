package com.cybertek.group1_assignments;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddCalendarEvent {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
        WebElement login = driver.findElement(By.id("prependedInput"));
        login.sendKeys("user1");

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginButton2 = driver.findElement(By.id("_submit"));
        loginButton2.click();
        BrowserUtils.sleep(4);
    }

    @Test
    public void addEvent() throws InterruptedException{
        WebElement activitiesMenu = driver.findElement(By.xpath("(//div[@id='main-menu']/ul/li/a)[3]"));
        activitiesMenu.click();
        BrowserUtils.sleep(3);
        WebElement calendarEvents = driver.findElement(By.xpath("//span[.='Calendar Events']"));
        calendarEvents.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        BrowserUtils.sleep(3);
        WebElement createCalendarEventButton = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        createCalendarEventButton.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        BrowserUtils.sleep(4);
        WebElement title = driver.findElement(By.xpath("(//input[contains(@id,'oro_calendar_event_form')])[2]"));
        String textToSend = "Group1 Assignment 06/07/2021 10:25 AM";
        title.sendKeys(textToSend);
        BrowserUtils.sleep(4);
        WebElement saveAndSubmitButton = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndSubmitButton.click();
        BrowserUtils.sleep(4);
        WebElement createdEvent = driver.findElement(By.xpath("//h1[@class='user-name']"));

        Assert.assertEquals(textToSend,createdEvent.getText());

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
