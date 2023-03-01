package com.cydeo.tests.SelfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_EtsyTitle_Verification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        WebElement EtsySearchBox = driver.findElement(By.id("global-enhancements-search-query"));
        EtsySearchBox.sendKeys("Wooden Spoon"+ Keys.ENTER);


        String ExpectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();
        if(actualTitle.startsWith(ExpectedTitle)){
            System.out.println("Title Passed!");
        }else{
            System.out.println("Title Failed!");
        }




    }
}
/*HWP #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”*/