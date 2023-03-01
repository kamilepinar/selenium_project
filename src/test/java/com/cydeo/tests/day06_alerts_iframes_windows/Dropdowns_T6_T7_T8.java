package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;



public class Dropdowns_T6_T7_T8 {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDownMethod(){
       driver.close();
    }

@Test
    public void dropdowns_task6(){

    Select yearDropDown= new Select(driver.findElement(By.xpath("//select[@id='year']")));
    Select monthDropDown= new Select(driver.findElement(By.xpath("//select[@id='month']")));
    Select dayDropDown= new Select(driver.findElement(By.xpath("//select[@id='day']")));

    //select visible text
    yearDropDown.selectByVisibleText("1933");

    //select by value
    monthDropDown.selectByValue("11");//icineki value month 12 degil

    //select by index
    dayDropDown.selectByIndex(0);

    String expectedYear = "1933";
    String expectedMonth = "December";
    String expectedDay = "1";

    //getting the actual values from browser
    String actualYear = yearDropDown.getFirstSelectedOption().getText();//sadece selected web element olur o yuzden get text string olarak almakicin
    String actualMonth = monthDropDown.getFirstSelectedOption().getText();
    String actualDay = dayDropDown.getFirstSelectedOption().getText();

    Assert.assertTrue(actualYear.equals(expectedYear),"Actual year is not Matching With expected-Test failed!");
    Assert.assertTrue(actualMonth.equals(expectedMonth));
    Assert.assertTrue(actualDay.equals(expectedDay));
    //third argument is optional and it only display if test failed


    }

    @Test
    public void dropDown_task7(){
        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id ='state']")));
        stateDropDown.selectByVisibleText("Illinois");
        stateDropDown.selectByValue("VA");
        stateDropDown.selectByIndex(5);//o inci index hepsinin genel adi olan tag


        String expectingOptionTExt = "California";
        String actualOptionText = stateDropDown.getFirstSelectedOption().getText();

       // Assert.assertTrue(actualOptionText.equals(expectingOptionTExt));
        Assert.assertEquals(actualOptionText,expectingOptionTExt,"State Dropdown value 'California' Failed-Not As Expected");

    }


    @Test
    public void dropDownTask8(){
        //this is html dropdown not sellect dropdown

        WebElement webSiteDropdown = driver.findElement(By.id("dropdownMenuLink"));
        webSiteDropdown.click();

        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        facebookLink.click();


        //verify facebook title
        String actualTitle = driver.getTitle();
        String expectedTitle ="Facebook - log in or sign up";

        Assert.assertEquals(actualTitle,expectedTitle,"titles are not equals");
        System.out.println(actualTitle+ " is actual title");




    }









}
/*TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1933” and verify it is selected.
Select year using : visible text
Select month using : value attribute
Select day using : index number*/

/*TC #7: Selecting state from State dropdown and verifying result
        1. Open Chrome browser
        2. Go to http://practice.cybertekschool.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)

 TC #8: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”


        */