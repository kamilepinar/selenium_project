package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @AfterMethod
    public void tearDownMethod(){
     //   driver.quit();
    }


    @Test
    public void order_verify_name_test(){


        //WebElement BobMartineCells = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[7]/td[2]"));
        //bu cell yeri degisince bulamayabilir

        WebElement BobMartineCells = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        //located with using text, even its change it will still find bob

        System.out.println("BobMartineCells.getText() = " + BobMartineCells.getText());

        //expected: BobMartine

        String expectedName = "Bob Martin";
        String actualName = BobMartineCells.getText();//get text koymazsan web elemeni stringe koyamazsin

        Assert.assertEquals(actualName,expectedName,"Names are not matching");

        //bu babaya gidio geri gelmeli yontem
       // WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        WebElement BobsOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));


        String expectedDate = "12/31/2021";
        String actualDate = BobsOrderDate.getText();

        Assert.assertEquals(actualDate,expectedDate,"Dates are not matching");
        System.out.println("BobsOrderDate = " + BobsOrderDate);
    }

    @Test
    public void test2_useOrderVerifyMethod(){
        String alexandraGray= WebOrderUtils.returnOrderDAte(driver,"Alexandra Gray");
        System.out.println(alexandraGray + " expected result is Alexandra grey");//iki line de yaptik soutv uzun oluodu

        String bartfisher = WebOrderUtils.returnOrderDAte(driver,"Bart Fisher");
        System.out.println("bartfisher date = " + bartfisher);
    }
    @Test

    public void test3(){
        WebOrderUtils.orderVerify(driver,"Bob Martin","12/31/2021");

    }





}
/*TC #1: Web table practice
1. Go to: https://practice.cydeo.com/web-tables
2. Verify Bob’s name is listed as expected.
Expected: “Bob Martin”
3. Verify Bob Martin’s order date is as expected
Expected: 12/31/2021*/