package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad1Page {
    //TC#41 : Dynamically Loaded Page Elements 1
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/1
    //2. Click to start
    //3. Wait until loading bar disappears
    //4. Assert username inputbox is displayed
    //5. Enter username: tomsmith
    //6. Enter password: incorrectpassword
    //7. Click to Submit button
    //8. Assert “Your password is invalid!” text is displayed.
    //Note: Follow POM Design Pattern
    public DynamicLoad1Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "pwd")
    public WebElement passwordField;

    @FindBy(id = "loading")
    public WebElement loadingBar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(id = "flash")
    public WebElement errorMessage;
}
