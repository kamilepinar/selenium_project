package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice.cydeo.com/abtest");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));

        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());//

        driver.navigate().refresh();
        System.out.println("Refreshing the page");

        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));//we are reassigning so it wont give
        //stalelement exception, we need to located it again

        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

    }
}
//2- Go to: https://practice.cydeo.com/abtest
//3- Locate “CYDEO” link, verify it is displayed
//4- Refresh the page.
//5- Verify it is displayed, again.