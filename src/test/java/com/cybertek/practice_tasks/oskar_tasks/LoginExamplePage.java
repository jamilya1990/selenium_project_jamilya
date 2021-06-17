package com.cybertek.practice_tasks.oskar_tasks;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginExamplePage {

    //1. Go to http://thedemosite.co.uk/login.php page, check the page whether opened or not
    //2. Check the following elements on login page;
    //a. Tab Title = 'Login example page to test the PHP MySQL online system'
    //b. Header = '4. Login'
    //c. Status Message = No login attempted
    //d. Info Message = 'Enter your login details you added on the previous page and test
    //the login. The success or failure will be shown above.'
    //e. Username field
    //f. Password password field
    //g. Test Login button
    //3. Perform a successful login and check the status message change
    //4. Perform a failed login and check the status message change

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("loginExamplePageURL"));
    }

    @Test
    public void loginTest() {
        String title = driver.getTitle();
        String expectedTitle = "Login example page to test the PHP MySQL online system";
        Assert.assertEquals(title,expectedTitle, "actual title = "+title);
        //b. Header = '4. Login'
        String header = driver.findElement(By.xpath("//strong[.='4. Login']")).getText();
        Assert.assertEquals(header,"4. Login", "header = "+header);

        //c. Status Message = No login attempted

        String message = driver.findElement(By.xpath("(//*[.='**No login attempted**'])[3]")).getText();
        Assert.assertEquals(message, "**No login attempted**", "message = "+message);
        //d. Info Message = 'Enter your login details you added on the previous page and test
        //the login. The success or failure will be shown above.'
        //e. Username field
        //f. Password password field
        //g. Test Login button
        //3. Perform a successful login and check the status message change
        //4. Perform a failed login and check the status message change

    }
}
