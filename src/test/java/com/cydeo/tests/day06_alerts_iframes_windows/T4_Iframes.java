package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");
    }
    @Test
    public void iframe_test(){

        //we have to switch to I frame to be able to locate the
        //driver.switchTo().frame("mce_0_ifr");// if there is id or name , this is id of iframe
        //TC #4: Iframe practice
        //we have to switch to iframe to be able to locate the web elements in there.
        //option#1- switch "id" attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option#2- switch using "index" number
        //driver.switchTo().frame(0);//eger uc tane i frame varsa search boxda cikar

        //option#3- switch using WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));


        WebElement paragraphText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(paragraphText.isDisplayed());//your content goes here text display

        //5
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();// little different between them

        //locate
        WebElement h3 = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(h3.isDisplayed());



    }
}
//TC #4: Iframe practice
//1. Create a new class called: T4_Iframes
//2. Create new test and make set ups
//3. Go to: https://practice.cydeo.com/iframe
//4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG