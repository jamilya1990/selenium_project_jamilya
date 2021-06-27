package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.pages.DynamicLoad1Page;
import com.cybertek.pages.DynamicLoad7Page;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebDriverWaitDynamicLoadPractice {
    //TC#40 : Dynamically Loaded Page Elements 7
    //3. Assert : Message “Done” is displayed.
    //4. Assert : Image is displayed.
    //Note: Follow POM

    @Test
    public void dynamic_load_7_test() {
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/7
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/7");

    //2. Wait until title is “Dynamic title”
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //use the object to wait for the explicit condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        DynamicLoad7Page page = new DynamicLoad7Page();
        Assert.assertTrue(page.doneMessage.isDisplayed());

        Assert.assertTrue(page.image.isDisplayed());
    }

    @Test
    public void dynamic_load_1_test(){
        //TC#41 : Dynamically Loaded Page Elements 1

        //Note: Follow POM Design Pattern

        //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
        Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/1");

        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();

        //2. Click to start
        dynamicLoad1Page.startButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //3. Wait until loading bar disappears
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));

        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.usernameField.isDisplayed());
        //5. Enter username: tomsmith
        dynamicLoad1Page.usernameField.sendKeys("tomsmith");
        //6. Enter password: incorrectpassword
        dynamicLoad1Page.passwordField.sendKeys("sjfsdfjksdjf");
        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();
        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());
    }
    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}
