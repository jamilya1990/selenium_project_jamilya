package com.cybertek.practice_tasks.TC1PracticeCybertek;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1ForgotPassword {
/*
* 1. Open Chrome browser
* 2. Go to http://practice.cybertekschool.com/forgot_password
* 3. Locate all the WebElements on the page using XPATH locator only (total of 6)
* a. “Home” link
* b. “Forgot password” header
* c. “E-mail” text
* d. E-mail input box
* e. “Retrieve password” button
* f. “Powered byCybertek School” text
* 4. Verify all WebElements are displayed. */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/forgot_password");
    }
    @Test
    public void forgotPassword(){
        WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2"));
        WebElement emailBox = driver.findElement(By.xpath("//input"));
        WebElement emailText = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("#form_submit"));
        WebElement poweredByCybertekSchool = driver.findElement(By.xpath("//a[text()='Cybertek School']/.."));
        WebElement poweredByCybertekSchool1 = driver.findElement(By.xpath("//div[text()='Powered by ']"));
        //Verify all WebElements are displayed:

        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailBox.isDisplayed() = " + emailBox.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCybertekSchool.isDisplayed() = " + poweredByCybertekSchool.isDisplayed());
        System.out.println("poweredByCybertekSchool1.isDisplayed() = " + poweredByCybertekSchool1.isDisplayed());

    }
}
