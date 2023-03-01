package com.cydeo.tests.DAY03_CssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("Https://login1.nextbasecrm.com");


        String expectedLoginbutton = "Log In";


        //locating login button using class attribuutes value
        //WebElement loginButton = driver.findElement(By.className("Login-btn"));//boylede olur

        //                         tagName[attributes='value']

        //locating loginbutton using cssSelector using type attributes value.
        //WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

        //locating loginbutton using cssSelector using class attributes value.
        //WebElement loginButton = driver.findElement(By.cssSelector("input[class='login-btn']"));

        //locating loginbutton using cssSelector using value attributes value.
        //WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));


//locating loginbutton using cssSelector using class attributes value. with
        //                                                     // tagname.classvalue
        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));


        String actualLoginText = loginButton.getAttribute("value");//this give Log In

        if(expectedLoginbutton.equals(actualLoginText)){
            System.out.println("loginButton Passed ");
        }else{
            System.out.println("Login button test failed");
        }




    }
}
/*TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “Log in” button text is as expected:
Expected: Log In
//
PS: Inspect and decide which locator you should be using to locate web
elements.
PS2: Pay attention to where to get the text of this button


/html/body/table/tbody/tr[2]/td/div/div/form/div[2]/input full absulute xpath




*/