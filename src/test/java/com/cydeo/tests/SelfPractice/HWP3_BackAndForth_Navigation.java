package com.cydeo.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP3_BackAndForth_Navigation {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");

        WebElement GmailButton = driver.findElement(By.className("gb_n"));//finds the gmail button
        //you can locate the element with(By.linkText("Gmail"))also
        GmailButton.click();//clicks the button

        String actualTitle = driver.getTitle();
        String expectedTitle = "Gmail";


        if(actualTitle.contains(expectedTitle)){
            System.out.println("Gmail title Passed!");
        }else{
            System.out.println("Gmail Title Failed!");
        }


        driver.navigate().back();//going back

       String expectedGoogleTitle = "Google";
       String actualGoogleTitle = driver.getTitle();
       if(expectedGoogleTitle.equals(actualGoogleTitle)){

           System.out.println("Google title Passed!");
       }else{
           System.out.println("Google title Failed!");
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