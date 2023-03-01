package com.cydeo.tests.DAY03_CssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("Https://login1.nextbasecrm.com");//go to


        String expectedLoginbutton = "Log In";//verify login in button


   //      tagName[@attributes='value'] sytanx
        //locating  login button using xpath using type attributes value
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));//using class attributes
  //   input where value equals to ''--->input[@type='submit']


        //    //input[@value='Log In']

        String actualLoginText = loginButton.getAttribute("value");//this give Log In

        if(expectedLoginbutton.equals(actualLoginText)){
            System.out.println("loginButton Passed ");
        }else{
            System.out.println("Login button test failed");
        }

    }
}
