package com.cybertek.tests.day10_webtable_properties_practice;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class DriverUsingExample {
    @Test
    public void howToUseDriver(){
        Driver.getDriver().get(ConfigurationReader.getProperty("googleURL"));
    }
}
