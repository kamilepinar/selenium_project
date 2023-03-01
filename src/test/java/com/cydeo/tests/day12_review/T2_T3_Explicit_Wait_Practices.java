package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_T3_Explicit_Wait_Practices {

    DynamicControlsPage dynamicControlsPage;
    @BeforeMethod
            public void setUp(){
        Driver.getDriver().get(" https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();// eger bunu class level verseydik
        // o zaman bir kere initiate yapicakti bir test icin ok ama multiple test olursa
        //o zaman null pinter exception olurdu, session will be completply terminate olurdu
//so we create in the class level but we instantiated in the before method//page object level da
        // you have to create object in class level and instantiate in the method
    }

    @AfterMethod
    public void tearDown(){
       // Driver.closeDriver();
    }

    @Test
    public void t2_remove_checkBox_test(){


       dynamicControlsPage.removeButton.click();


        //created the object of web driver wait and set up the contracter arg
        //use the wait object with the proper syntac to create explicit wait condition
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));


       //assert method is expecting false value to pass the test
        //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
       // Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());

        //5- Verify:
        //a. Checkbox is not displayed
        // dynamicControlsPage.checkbox.isDisplayed() --> if displayed, returns true;
        // dynamicControlsPage.checkbox.isDisplayed() --> if not displayed, returns false;

        //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());

        try{
            //assertFalse method is expecting a "false" boolean value to PASS the test.
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());

        }catch (NoSuchElementException n){
            //n.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page.");
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
    }


    @Test
    public void t3_input_input_box_test(){
        //3- Click to “Enable” button
        //use the object to click to enable button
        dynamicControlsPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled(), "Input box is not enabled!!!");

        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed(), "Message is not enabled!!!");

        String actualMessageText = dynamicControlsPage.message.getText();

        Assert.assertTrue(actualMessageText.equals("It's enabled!"));
    }






    }

/*TC #2: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Remove” button
4- Wait until “loading bar disappears”
5- Verify:
a. Checkbox is not displayed
b. “It’s gone!” message is displayed.
NOTE: FOLLOW POM


TC #3: Explicit wait practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/dynamic_controls
3- Click to “Enable” button
4- Wait until “loading bar disappears”
5- Verify:
a. Input box is enabled.
b. “It’s enabled!” message is displayed.
NOTE: FOLLOW POM
*/