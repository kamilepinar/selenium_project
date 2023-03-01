package com.cydeo.tests.DAY03_CssSelector_Xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_Locator_getText_getAttributes {
    public static void main(String[] args) {

         WebDriver driver = WebDriverFactory.getDriver("chrome");
         driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com");

        String expectedLabelText = "Remember me on this computer";

        String actualLabelText = driver.findElement(By.className("login-item-checkbox-label")).getText();


        if(actualLabelText.equals(expectedLabelText)){
            System.out.println("Label Verification passed!!");
        }else{
            System.out.println("Label verification Failed!!");
        }



        String expectedForgetPassword = "FORGOT YOUR PASSWORD?";

       WebElement forgetPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgetPasswordText =forgetPasswordLink.getText();


        if(expectedForgetPassword.equals(actualForgetPasswordText)){

            System.out.println("Forget password passed");
        }else{
            System.out.println("actualForgetPasswordText = " + actualForgetPasswordText);
            System.out.println("expectedForgetPassword = " + expectedForgetPassword);
            System.out.println("forget password failed!");
        }


        String expectedHref = "forgot_password=yes";
        String actualHrefValue = forgetPasswordLink.getAttribute("href");

        if(actualHrefValue.contains(expectedHref)){
            System.out.println("Href is Passed!");
        }else{
            System.out.println("Href is failed!");
        }
//href="/?forgot_password=yes"
    }
}
/*TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Verify “remember me” label text is as expected:
Expected: Remember me on this computer
4- Verify “forgot password” link text is as expected:
Expected: Forgot your password?
5- Verify “forgot password” href attribute’s value contains expected:
Expected: forgot_password=yes

PS: Inspect and decide which locator you should be using to locate web
elements.

*/