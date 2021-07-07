package com.cybertek.practice_tasks.office_hours_day06;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Test;

public class AmazonTestWithPOM {

    @Test
    public void testAmazon(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazonURL"));
    }
}
