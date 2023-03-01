package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class t7_t8_t9_POM_Practices {


    LibraryLoginPage loginPage;
    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com ");
        loginPage = new LibraryLoginPage();
    }
    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

    @Test
    public void t7_field_required_error_message_test(){
       // Driver.getDriver().get("https://library1.cydeo.com");
      //  LibraryLoginPage loginPage = new LibraryLoginPage(); bunlar setupda artik
        loginPage.signInButton.click();

        Assert.assertTrue(loginPage.fieldRequiredErrorMessage.isDisplayed());

    }

    @Test
    public void t8_email_format_error_message_test(){
        //TC #8: Invalid email format error message test

        //3- Enter invalid email format
        loginPage.emailInput.sendKeys("username");
        loginPage.signInButton.click();
        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(loginPage.enterValidEmailErrorMessage.isDisplayed());
    }

    @Test
    public void t9_wrong_email_or_password_error_message(){
        //TC #9: Library negative login

        //3- Enter incorrect username or incorrect password
       loginPage.emailInput.sendKeys("username@wrongmail.com");
       loginPage.passwordInput.sendKeys("incorrectpassword");
       loginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Sorry, Wrong Email or Password

        Assert.assertTrue(loginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());

        //mor olanlarin hepsi pages libraryde bulunmus locatorlar
        //creating login bage object and than we are calling this contractor inside the library page class
        //it will call the driver insede the contractor, if we dont call this line we can not process any of these

    }


}
/*TC #7: Required field error message test
        1- Open a chrome browser
        2- Go to: https://library1.cydeo.com
        3- Do not enter any information
        4- Click to “Sign in” button
        5- Verify expected error is displayed:
        Expected: This field is required.
        NOTE: FOLLOW POM DESIGN PATTERN*/