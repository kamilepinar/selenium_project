package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {

    public W3Page(){
        PageFactory.initElements(Driver.getDriver(),this);
        //create constractor and initil driver instnce and object of the current class
    }
    //instead of find element we use find by anatation

    @FindBy(id = "demo")
    public WebElement paragraph;
}
