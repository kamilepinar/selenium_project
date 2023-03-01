package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AloDokter {

    @Test
    public void search_box_test() {
        Driver.getDriver().get("https://www.alodokter.com/");


        //Using JS Codes -- if you are using version lower than Selenium 4
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //Shadow Root - Open
        String str = "document.querySelector(\"hero-view\").shadowRoot.querySelector(\"#searchSpecialities\").value = \"max\"";
        js.executeScript(str);

    }
    @Test
    public void challenge7() {

        //How to handle closed Shadow element

        Driver.getDriver().get("https://letcode.in/shadow");
        BrowserUtils.sleep(1);
        //Locate the closest element which is outside closed shadow root. It could be the host element for that shadow root.
        WebElement element = Driver.getDriver().findElement(By.id("close-shadow"));

        //Now focus on this outside element by using click() method
        element.click();

        //Now use Actions class to press the TAB key to focus on the closed shadow root element.
        Actions act = new Actions(Driver.getDriver());
        act.sendKeys(Keys.TAB).perform();

        //Now use Actions class to perform any action on the closed shadow dom element like sendKeys() or click() etc.
        act.sendKeys("maximilian@gmail.com").perform();


    }
}