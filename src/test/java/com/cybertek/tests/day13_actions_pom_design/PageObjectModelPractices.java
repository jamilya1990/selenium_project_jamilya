package com.cybertek.tests.day13_actions_pom_design;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageObjectModelPractices {
    @Test
    public void negative_logit_to_library_test(){
        Driver.getDriver().get("https://library2.cybertekschool.com/login.html");

        //Create object of the class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //when we create the object of this, constructor will automatically initialize driver and object of LibLogPage
        //We will be able to use the selenium method through the object of the class

        //2 - enter incorrect email
        loginPage.inputEmail.sendKeys("a@something.com");

        //3 - enter wrong password

        loginPage.inputPassword.sendKeys("wrong password");

        //4 - sign in
        loginPage.signInButton.click();
        BrowserUtils.sleep(3);

        //5 - verify error message
        Assert.assertTrue(loginPage.incorrectEmailOrPasswordError.isDisplayed(), loginPage.incorrectEmailOrPasswordError.getText());


    }
}
