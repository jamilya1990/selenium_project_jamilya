package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //#1 - Create properties object
    private static Properties properties = new Properties();

    static {
        //#2 - Load the file into FileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");

        //#3 - load properties object with the file(configuration.properties)
            properties.load(file);

        //#4 - close file
            file.close();
        } catch (IOException e) {
            System.out.println("Jamilya, file not found in configurations.properties.");
        }
    }
    //Use the above created logic to create a re-usable static method:

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }


}
