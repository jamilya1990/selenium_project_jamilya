package com.cybertek.tests.day12_actions_upload_jsexecuter;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14Upload {
    //TC #14: UploadTest1.
    // Go to http://practice.cybertekschool.com/upload
    // 2.Find some small file from your computer, and get the path of it.
    // 3.Upload the file.
    // 4.Assert: -File uploaded text is displayed on the page

    @Test
    public void uploadTest(){
        // Go to http://practice.cybertekschool.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("cybertekUploadURL"));

        // 2.Find some small file from your computer, and get the path of it.
        String docPath = "C:/Users/jamilya.petsenyuk/Desktop/debug.log";
        // 3.Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(3);
        chooseFileButton.sendKeys(docPath);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //actions.click(uploadButton);

        // 4.Assert: -File uploaded text is displayed on the page

        WebElement confirmationText = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(confirmationText.isDisplayed());
    }
}
