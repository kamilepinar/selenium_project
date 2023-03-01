package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {


        //TC #1: Cydeo practice tool verifications
         //       1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

           //     2. Go to https://practice.cydeo.com

        driver.navigate().to("https://practice.cydeo.com");

        driver.manage().window().maximize();

             //   3. Verify URL contains
        String expectedURL = "cydeo";
        String actualURL= driver.getCurrentUrl();
        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification Passed!!!");
        }else{
            System.out.println("URl verification Failed!!!");
        }

             //Expected: cydeo
               // 4. Verify title:
             //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle(); //this will return practice

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is passed!!");
        }else{
            System.out.println("Title verification is Failed!!");
        }


        //close the browsers


        if(driver.getTitle().equals("Practice")){
            System.out.println("Pass!!");
        }else{
            System.out.println("Failed!");
        }

    }
}
