package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {
    //TC#40 : Dynamically Loaded Page Elements 7
    //1. Go to http://practice.cybertekschool.com/dynamic_loading/7
    //2. Wait until title is “Dynamic title”
    //3. Assert : Message “Done” is displayed.
    //4. Assert : Image is displayed.
    //Note: Follow POM
    public DynamicLoad7Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//strong[text()='Done!']")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@alt='square pants']")
    public WebElement image;
}
