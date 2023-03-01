package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadTest {

    @Test
    public void uploading_test(){

        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.

        //bu path kendin bilgisayarindan girip file right click properties- security bolumunden
        //selenium browser disina cikamadigindan bu yontemle upload yapiyoruz

         String path = "C:\\Users\\mngll\\OneDrive\\Desktop\\Selenium Class notes and slides\\Day 10 Class Notes.txt";

        //3. Upload the file. Use sendKeys() method and pass the "path" as a String.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);

        chooseFileButton.sendKeys(path);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        //4. Assert:
        //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header text is not displayed!!!");



    }
}
