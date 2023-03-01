package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LetCode_shadowRoot {

    @Test
    public void myTest(){
        Driver.getDriver().get("https://letcode.in/shadow");
        BrowserUtils.sleep(1);

        //First, we would be locating the shadow_host element by using its id, after which we would get the Shadow Root element using the getShadowRoot() method.
        //Next, We would get the Shadow Root element using the getShadowRoot() method.
        //Finally, we would sendkeys to the input box
        WebElement openShadowElement = Driver.getDriver().findElement(By.id("open-shadow")).getShadowRoot().findElement(By.cssSelector("#fname"));
        openShadowElement.sendKeys("max");

    }

}
