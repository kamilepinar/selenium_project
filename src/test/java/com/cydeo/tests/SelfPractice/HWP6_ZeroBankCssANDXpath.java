package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP6_ZeroBankCssANDXpath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(" http://zero.webappsecurity.com/login.html");

       // WebElement findHeader= driver.findElement(By.xpath("//h3"));
        //WebElement findHeader= driver.findElement(By.tagName("h3"));
        WebElement findHeader =driver.findElement(By.cssSelector("h3"));//cunku attribute yok value yok

        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = findHeader.getText();

        if(actualHeader.equals(expectedHeader)){
            System.out.println("Header test passed!");
        }else{
            System.out.println("Header test failed!");
        }


    }
}
/*HWP #2: Zero Bank header verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify header text
Expected: “Log in to ZeroBank”*/