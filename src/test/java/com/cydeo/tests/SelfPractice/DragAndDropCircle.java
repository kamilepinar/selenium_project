package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropCircle {


    @Test
    public void draggingTest(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");

        WebElement circle = Driver.getDriver().findElement(By.id("draggable"));

        Actions action = new Actions(Driver.getDriver());

        action.moveToElement(circle).clickAndHold(circle).dragAndDrop(circle,Driver.getDriver().findElement(By.id("droptarget"))).perform();

        Driver.closeDriver();
    }
}
