package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP8_Cydeo_Xpath_CssSelector {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/inputs");





        //                                       (BY.LinkText("Home");
        // WebElement HomeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement HomeLink = driver.findElement(By.xpath("//a[.='Home']"));//(  //a[Text()='Home']



        // WebElement HomeLink = driver.findElement(By.cssSelector("a.nav-link"));
       // WebElement HomeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));

        HomeLink.click();

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Home Link Title Verificaion passed");
        }else{
            System.out.println("Home Link Title Verification Failed!");
        }


    }
}
/*HWP #4: Practice Cydeo – xpath locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “xpath” locator*/