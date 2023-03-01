package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP5_EtsyXpath {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();


        driver.get(" https://www.etsy.com");

        // bu css selector tagname[attributes='value']
        //WebElement EtsySearchBox = driver.findElement(By.cssSelector("input[id='global-enhancements-search-query']"));
        //tag.value da olur css de 2nd syntax
        //tag#idvalue da olur


        WebElement EtsySearchBox = driver.findElement(By.xpath("//input[@type='text']"));
                                // driver.findElement(By.xpath(" //input[@data-id='search-query']"  ));
                              ////driver.findElement(By.xpath(" //input[@id='global-enhancements-search-query']"  ));
          //                                            by.Xpath("  //input[@name='search query']




        EtsySearchBox.sendKeys("Wooden Spoon"+ Keys.ENTER);


        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!");
        }else{
            System.out.println("Title verification Failed!");
        }






    }
}
/*HWP #1: Etsy Title Verification
1. Open Chrome browser
2. Go to https://www.etsy.com
3. Search for “wooden spoon”
4. Verify title:
Expected: “Wooden spoon - Etsy”*/