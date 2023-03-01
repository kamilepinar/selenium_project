package com.cydeo.tests.day02_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttributes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/registration_form");
        WebElement header = driver.findElement(By.tagName("h2"));
        String expectedHeatherText = "Registration Form";
        String ActualHeatherText = header.getText();//this will return the text of header

        if(ActualHeatherText.equals(expectedHeatherText)){
            System.out.println("Header text verification Passed!");
        }else {
            System.out.println("Text verification failed!");
        }

        WebElement firstNameInput = driver.findElement(By.className("form-control"));//webelement first name input box
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = "placeholder";


        if(actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("PlaceHOlder  attributes verification passed");
        }else{
            System.out.println("PlaceHolder verification passed");

        }


    }
}
/*TC #5: getText() and getAttribute() method practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first */