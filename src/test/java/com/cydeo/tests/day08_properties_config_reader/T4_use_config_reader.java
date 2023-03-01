package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_use_config_reader {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(ConfigurationReader.getProperty("googleURL"));//direk https google yerine soft code yaptik
    }




    @Test

    public void google_search_test(){

        WebElement GoogleSearchBox = driver.findElement(By.cssSelector("input[class='gLFyf']"));
        //GoogleSearchBox.sendKeys("Apple" + Keys.ENTER);
        GoogleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //String expectedTitle = "Apple - Google Search";
        String expectedTitle = ConfigurationReader.getProperty("searchValue") +" - Google Search";
        // first part is dynamic so we assert that from configProp second part is static usualy
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
/*TC #4: Google search
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Write “apple” in search box
        4- Verify title:
        Expected: apple - Google Search

        Use `configuration.properties` for the following:
        1. The browser type
        2. The URL
        3. The search keyword
        4. Make title verification dynamic. If search value changes, title
        assertion should not fail.*/