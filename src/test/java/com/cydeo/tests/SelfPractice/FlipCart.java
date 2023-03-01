package com.cydeo.tests.SelfPractice;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipCart  {




    @Test
    public void HeadPhone(){
        Driver.getDriver().get("https://www.flipkart.com/");

        WebElement popup = Driver.getDriver().findElement(By.xpath("//div//button[@class='_2KpZ6l _2doB4z']"));
        popup.click();

        WebElement Electronics = Driver.getDriver().findElement(By.xpath("//div[text()='Electronics']"));

        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(2);

        actions.moveToElement(Electronics).perform();

        WebElement wiredHeadPhones =Driver.getDriver().findElement(By.xpath("//a[.='Wired Headphones']"));
        wiredHeadPhones.click();



    }

//div[@class='InyRMC _3Il5oO']//div[4]//a//div//div electronic
//div//a[.='Electronics']

    //Select ElectronicsDropDown= new Select(driver.findElement(By.xpath("(//div[@class='xtXmba'])[4]")));//div[text()='Electronics']

    //driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='InyRMC _3Il5oO']")));
    // WebElement electronics = driver.findElement(By.xpath("//div[@class='InyRMC _3Il5oO']//div[4]//a[.='Wired Headphones']\n"));
//div[@class='InyRMC _3Il5oO']//div[4]//a[.='Wired Headphones']
    //   (//div[@class='InyRMC _3Il5oO']//div[4]//div//a[@class='_6WOcW9 _3YpNQe'])[4]
    // (//div[@class='InyRMC _3Il5oO']//div[4]//div//a[@class='_6WOcW9 _3YpNQe'])[4]
    //WebElement headphone= driver.findElement(By.xpath("(//div[@class='InyRMC _3Il5oO']//div[4]//a//div//div)[10]//a[.='Wired Headphones']"));

    // wired.click();


}