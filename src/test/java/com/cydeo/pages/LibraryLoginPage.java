package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
public LibraryLoginPage(){
    PageFactory.initElements(Driver.getDriver(),this);
}//pagefactory seleniumdan geliyor

//Find by anatotion instead of find by element //by by to find by element
    // WebElement signInButton = Driver.getDriver().findElement(By.xpath("//button[.='Sign in']"));

    //#2- Use @FindBy annotation instead of findElement method
    @FindBy(id = "inputEmail" )
    public WebElement emailInput;

    @FindBy(id="inputPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enterValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;


}
/*TC #7: Required field error message test
1- Open a chrome browser
2- Go to: https://library1.cydeo.com
3- Do not enter any information
4- Click to “Sign in” button
5- Verify expected error is displayed:
Expected: This field is required.
NOTE: FOLLOW POM DESIGN PATTERN*/