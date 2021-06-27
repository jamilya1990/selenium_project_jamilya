package com.cybertek.tests.base;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
   public WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //WebDriverFactory.getDriver("chrome");

        //I can store the value of URL into string and pass it to .getDriver()
        //String urlBrowser = ConfigurationReader.getProperty("browser"); //store value of the key in String
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
}
class Test extends TestBase{
    public void setupMethod(){

    }
}
