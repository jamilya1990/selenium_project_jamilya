package com.cybertek.tests.day9_properties_browser_utils;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file() throws IOException {
        //#1 - Create object of Properties class(coming from Java library)

        Properties properties = new Properties();

        //#2 - Open the file using FileInputStream

        FileInputStream file = new FileInputStream("configuration.properties");

        //#3-Load the properties object with our file
        properties.load(file);

        //#4 - reading from configuration.properties file by passing the key

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));


        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));

    }
    @Test
    public void usingPropertiesMethod(){
        System.out.println("ConfigurationReader.getProperty(\"browser\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"env\") = " + ConfigurationReader.getProperty("env"));
    }
}
