package com.cybertek.practice_tasks.TC1PracticeCybertek;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.SmartBearUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearTest {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("smartBearLoginURL"));
        SmartBearUtils.loginToSmartBear(driver);

    }

  //  @Test
   // public void loggingInToSmartBear(){
     //   SmartBearUtils.loginToSmartBear(driver);
    //}
    @Test
    //TC#2: Smartbear software order placing
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click on Login button
    // 6.Click on Order
    // 7.Select familyAlbum from product, set quantity to 2
    // 8.Click to “Calculate” button

    public void orderPlacing(){
       // SmartBearUtils.loginToSmartBear(driver);
        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();

        Select selectProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        selectProduct.selectByVisibleText("FamilyAlbum");
        System.out.println("selectProduct.getFirstSelectedOption() = " + selectProduct.getFirstSelectedOption());
        BrowserUtils.sleep(3);
        Assert.assertTrue(selectProduct.getFirstSelectedOption().getText().equals("FamilyAlbum"));

        WebElement quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();
        // 9.Fill address Info with JavaFaker
        // •Generate: name, street, city, state, zip code


        Faker faker = new Faker();
        System.out.println("addressFaker.address() = " + faker.address());
        String streetAddress = faker.address().streetAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.number().digits(5);

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys(firstName+" "+lastName);

        WebElement street = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        street.sendKeys(streetAddress);

        WebElement cityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityBox.sendKeys(city);

        WebElement stateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateBox.sendKeys(state);

        WebElement zipCodeBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipCodeBox.sendKeys(zipCode);
        // 10.Click on “visa” radio button
        // 11.Generate card number using JavaFaker
        // 12.Click on “Process”
        // 13.Verify success message “New order has been successfully added.”
        WebElement visa = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visa.click();
        BrowserUtils.sleep(4);
        Assert.assertTrue(visa.isSelected());
        String creditCard = faker.finance().creditCard();
        String creditCardNumber = "";
        for (int i = 0; i < creditCard.length(); i++) {
            if(Character.isDigit(creditCard.charAt(i))){
                creditCardNumber+=creditCard.charAt(i);
            }
        }

        WebElement creditCardBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        creditCardBox.sendKeys(creditCardNumber);
        BrowserUtils.sleep(4);

        //Date futureDate = faker.date().future(012024, TimeUnit.DAYS);
        WebElement date = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        date.sendKeys("01/22");
        BrowserUtils.sleep(3);
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

    }
    @Test
    public void orderVerification(){
        //TC#3: Smartbear software order verification
        // 1.Open browser and login to Smartbear software
        // 2.Click on View all orders
        // 3.Verify Susan McLaren has order on date “01/05/2010”
        WebElement susanMcLaren = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[.='Susan McLaren']//following-sibling::td[3]"));
        Assert.assertNotNull(susanMcLaren);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

