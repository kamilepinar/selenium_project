package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.get("https://www.google.com/");

        //Locate search box by name. google search boz name hep q imis
        WebElement googleSearchBox = driver.findElement(By.name("q"));

        //googleSearchBox.sendKeys("apple");//this will write in search box

        //googleSearchBox.sendKeys(Keys.ENTER); // this method wil hit enter after write what ever you want

        googleSearchBox.sendKeys("apple" + Keys.ENTER);//this is two action in one line
        //if you need to wait before pressin enter you can write them seperatly like in commend out and put Thread.sleep in between


        String expectedInBeginingOfTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.startsWith(expectedInBeginingOfTitle)){
            System.out.println("Title verification Passed!");
        }else{
            System.out.println("Title verification Failed!!");
        }





    }
}
