package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP7_GoogleXpathAndCss {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("https://google.com");


        //WebElement gmailButton = driver.findElement(By.cssSelector("a[class='gb_n']"));//tag[attr='value']
        //WebElement gmailButton = driver.findElement(By.cssSelector("a.gb_n")); tagname.value


        //                                          By.LinkText("Gmail") en basiti
       // WebElement gmailButton = driver.findElement(By.xpath("//a[@class='gb_n']"));bundan bir tane daha var ayni value
        // ama assagida oldugu icin bu da calisti , ama attributes degistircez

        //WebElement gmailButton = driver.findElement(By.xpath("//a[@data-pid='23']"));

                                                                             //a[.='Gmail']
        WebElement gmailButton = driver.findElement(By.xpath("//a[text()='Gmail']"));
        gmailButton.click();

        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if(actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Gmail Title verification PASSED!");
        }else{
            System.out.println("Gmail Title Verification Failed!");
            System.out.println("actualGmailTitle = " + actualGmailTitle);
        }

        driver.navigate().back();
        driver.getTitle();

        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();

        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Google Title verification Passed!");
        }else{
            System.out.println("Google Title  verification Failed!");
        }

    }
}
/*TC #3: Back and forth navigation
1- Open a chrome browser
2- Go to: https://google.com
3- Click to Gmail from top right.
4- Verify title contains:
Expected: Gmail
5- Go back to Google by using the .back();
6- Verify title equals:
Expected: Google*/