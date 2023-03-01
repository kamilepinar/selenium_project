package com.cydeo.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP4_ClassLocatorPractice {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");
        WebElement HomeLink = driver.findElement(By.className("nav-link"));
        HomeLink.click();

        String actualTitleOfPracticePage = driver.getTitle();

        String expectedTitleOfPracticePage = "Practice";

        if(actualTitleOfPracticePage.contains(expectedTitleOfPracticePage)){
            System.out.println("Title Passed!");
        }else{
            System.out.println("Title failed!");
        }







    }
}
/*TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice
PS: Locate “Home” link using “className” locator*/