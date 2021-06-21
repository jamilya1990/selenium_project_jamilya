package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Creating the private constructor, so this class's object is not reachable from outside
     */
    private Driver(){}

    /*
    Making 'drier' instance private so it is not reachable from outside
    We make it static, cuz we want it to run before everything else, and also we will use it in a static method
     */
    private static WebDriver driver; //we created this, but didn't instantiate it yet, so it returns null

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it
     */
    public static WebDriver getDriver(){
        if(driver==null){
            /*
            We read our browser type from configuration.properties file using .getProperty method we created in ConfigurationReader class
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine to open specific type of browser/driver
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "internet explorer":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        /*
        Same driver instance will be returned everytime we call Driver.getDriver() method
         */
        return driver;
    }

    /*
    This method makes sure we have some form of driver session. Either null or not null it must exist.
     */
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
