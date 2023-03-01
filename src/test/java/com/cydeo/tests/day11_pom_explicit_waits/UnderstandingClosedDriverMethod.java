package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class UnderstandingClosedDriverMethod {

    public void test1(){
        Driver.getDriver().get("https://google.com");
        //verify something
        //Driver.getDriver() --> driver
        //Driver.getDriver().close();
        Driver.closeDriver();//if put quit the other test can not execute because quit is terminating all browsers
    }

    @Test
    public void test2(){//bu yontemle biri fail olursa digeri pass yapabilsin
        Driver.getDriver().get("https://google.com");
        //verify something else
        //Driver.getDriver().close();
        // //Driver.getDriver().quit it terminateing all selenim session so when we go back  singletoncheck its not null its not existing


        Driver.closeDriver();//if driver is not null we assigne in utility to quit then assign to null again
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        //verify something completely different
        //Driver.getDriver().close();
        Driver.closeDriver();
    }
}
