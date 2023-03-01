package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException{

        //setup browser driver

      WebDriverManager.chromedriver().setup();

        //create instance of chrome browser
       WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//to maximize the open page(buyutuyor)
        //driver.manage().window().fullscreen();// mac icin bu method var

        //fo to tesla.com

        driver.get("https://tesla.com");

        //System.out.println("driver.getTitle = " + driver.getTitle());
        String currentTitle = driver.getTitle();
        System.out.println("Current title: "+currentTitle);


        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        // use navigate back(); o go back
        driver.navigate().back();

        //stop execution for 3 seconds

        Thread.sleep(3000);

        //user navigate forward() to go forward

        driver.navigate().forward();

        //stop execution for 3 seconds

        Thread.sleep(3000);

        //user navigate refresh the page

        driver.navigate().refresh();

        //navigate to google.com using navigate().to another url

        driver.navigate().to("https://www.google.com");


        //get the title of the page
        //driver.getTitle();// we ask to get the title but did not ask what to do so it wont do anything

        //System.out.println("driver.getTitle = " + driver.getTitle());//comsolda google olur

        //String currentTitle2 = driver.getTitle();yenisini yapicagina eskisini assign yapti
        currentTitle =driver.getTitle();
        System.out.println("Current Title : "+ currentTitle);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

       // driver.close();//only the curetn browsr//only close one window
       // driver.quit();//this close all of the open browsers// bu o window icindeki tum tablari kapatiyor
        //her run yaptiginda farkli bir session id ile giriyor o yuzden onceden denediklerimi kapatmadi








    }
}
