package com.cydeo.tests.day05_TestNG_intro_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_StaleElement_reference {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement addElementbutton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementbutton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        System.out.println("deleteButton.isDisplayed() = " + deleteButton.isDisplayed());//expecxting true


        deleteButton.click();


        //cunku delete click yapinca sayfadan gitti bu artik stale element expection vericek
        // bu deleted oldugu icin try catch kullanmamiz gerek


        try {
            System.out.println("deleteButton.isDisplayed(),expecting false = " + deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceEXception  happened due to element being deleted from the page.");
            System.out.println("Which concludes our test case -PASSING!-");
            System.out.println("deleteButton.isDisplayed()= false ");
        }
    }





}
   /* DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        TC #1: StaleElementReferenceException handling
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/add_remove_elements/
        3. Click to “Add Element” button
        4. Verify “Delete” button is displayed after clicking.
        5. Click to “Delete” button.
        6. Verify “Delete” button is NOT displayed after clicking.
        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS*/