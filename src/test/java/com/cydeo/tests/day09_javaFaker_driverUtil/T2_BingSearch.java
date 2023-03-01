package com.cydeo.tests.day09_javaFaker_driverUtil;

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

public class T2_BingSearch {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
       driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.get(ConfigurationReader.getProperty("bingURL"));
  // if you dont pass correct key it will trow nullpointerexceptions
    }

    @Test
    public void bingSearch(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);


        String actualTitle = driver.getTitle();
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+ " - Search";
        // we are making expected value dynamic base on the word we are searching apple mi orang mi yaziyosun

        Assert.assertEquals(actualTitle,expectedTitle);

    }

}
/*TC #1: Bing search
        1- Open a chrome browser
        2- Go to: https://bing.com
        3- Write “apple” in search box
        4- Verify title:

        Expected: apple - Search

        Use `configuration.properties` for the following:
        1. The browser type
        2. The URL
        3. The search keyword
        4. Make title verification dynamic. If search value changes, title
        assertion should not fail.*/