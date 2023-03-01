package com.cydeo.tests.DAY03_CssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Locator_getText {
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();

       // WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");
        WebElement inputUserName = driver.findElement(By.className("login-inp"));
        inputUserName.sendKeys("IncorrectUser");

        WebElement inputPassword = driver.findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedErrorText = "Incorrect login or password";
        String actualErrorText = driver.findElement(By.className("errortext")).getText();


        if(actualErrorText.equals(expectedErrorText)){
            System.out.println("Error test verification is passed!!");
        }else{
            System.out.println("Error text verification Failed!!!");
        }








    }
}
/*TC #1: NextBaseCRM, locators and getText() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

PS: Inspect and decide which locator you should be using to locate web*/