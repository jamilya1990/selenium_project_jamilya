package com.cybertek.group1_assignments;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddEvent {
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
    }

    @Test
    public void addEvent() throws InterruptedException {
        Thread.sleep(3000);
        WebElement fleet = driver.findElement(By.xpath("//div[@id='main-menu']/ul/li/a"));
        fleet.click();
        WebElement vehicle = driver.findElement(By.xpath("//span[.='Vehicles']"));
        vehicle.click();
        WebElement licenseCLick = driver.findElement(By.xpath("//td[.='Cybertek123456']"));
        licenseCLick.click();
        //find element title of the current page
        String currentTitle = driver.getTitle();
        Thread.sleep(3000);
        WebElement addEvent = driver.findElement(By.xpath("//a[@class='btn icons-holder-text no-hash']"));
        addEvent.click();
        Thread.sleep(2000);
      // driver.switchTo().window("Add Event");
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().contains("Add Event")){
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //String mainHandle = driver.getWindowHandle();


        WebElement title = driver.findElement(By.xpath("//input[@id='oro_calendar_event_form_title-uid-60bbc366370ac']"));
        title.sendKeys("Group1Assignment");
        //WebElement ownerButton = driver.findElement(By.className("add-on btn entity-select-btn"));
        //ownerButton.click();
        WebElement saveButton = driver.findElement(By.xpath("//button[.='Save']"));
        saveButton.click();

        driver.switchTo().window(currentTitle);



    }
}
