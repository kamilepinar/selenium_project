package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_AlertPractices {
    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @AfterMethod
    public void tearDownMethod(){
       // driver.close();
    }

    @Test
    public void information_alert_test1(){

        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));//text

        informationAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement resulttext = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resulttext.isDisplayed(),"Result text is not displayed!");

        String expectedText= "You successfully clicked an alert";
        String actualText = resulttext.getText();

        Assert.assertEquals(actualText, expectedText,"Actual result is not as expected");




    }

@Test
    public void confirmation_alert_t2(){
      WebElement ConfirmationAlert =   driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

      ConfirmationAlert.click();

      Alert alert = driver.switchTo().alert();
      alert.accept();

      WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

      Assert.assertTrue(resultText.isDisplayed(), " Alert2 test failed!");

}

@Test
    public  void confirmation_alert_test3(){
    WebElement ConfirmationAlert = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

    ConfirmationAlert.click();

    Alert alert = driver.switchTo().alert();
    alert.sendKeys(" hello");
    alert.accept();




    String expectedText="You entered: hello";
    String actualText =driver.findElement(By.xpath("//p[@id='result']")).getText();


    Assert.assertEquals(actualText,expectedText);

}


}
/*TC #1: Information alert practice
        1. Open browser
        2. Go to website: http://practice.cydeo.com/javascript_alerts
        3. Click to “Click for JS Alert” button
        4. Click to OK button from the alert
        5. Verify “You successfully clicked an alert” text is displayed.


TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.




TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.



        */