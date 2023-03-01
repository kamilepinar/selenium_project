package com.cydeo.tests.day07_utilities_javafakers;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://login1.nextbasecrm.com/");
    }

    @Test
    public void test2_crm_login(){

       /* WebElement inputUserName =driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cydeo.com");

        WebElement passwordInputBox =driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordInputBox.sendKeys("UserUser");

        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();*/

        CRM_Utilities.login_crm(driver);



        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver,"Portal");

    }


    @Test
    public void test3_crm_login(){

        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");

        //6. Verify title is as expected:
        // Expected: Portal
        // We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowserUtils.sleep(3);
        BrowserUtils.verifyTitle(driver, "Portal");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


}
/*TC #4: Login scenario
1. Create new test and make set ups
2. Go to: http://login1.nextbasecrm.com/
3. Enter valid username
4. Enter valid password
5. Click to `Log In` button
6. Verify title is as expected:
Expected: Portal

USERNAME PASSWORD
helpdesk1@cydeo.com UserUser
helpdesk2@cydeo.com UserUser*/