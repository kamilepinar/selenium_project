package com.cydeo.tests.day05_TestNG_intro_dropdown;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {

    //before and after method place does not matter they will always run before and after of each @test
    @BeforeClass
    public void setupClass(){
        System.out.println("----> Before class is running!!!");//runs only one time not from every @test
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("----> After class is running!!!"); //this rns after class run and this tear down, quiting
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("--> Before method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> After method is running...");
    }

    @Test (priority = 1)
    public void test1(){
        System.out.println("Test 1 is running...");
        //Assert Equals method will compare two of the same values. If returns true, pass. False, fails.
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);

    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");

        String actual = "white";
        String expected = "white";

        Assert.assertTrue(actual.equals(expected));
    }

}
