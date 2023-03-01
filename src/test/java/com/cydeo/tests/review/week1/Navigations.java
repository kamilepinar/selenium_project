package com.cydeo.tests.review.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//first thing you need to do
        // bunu yazmasada yeni versionda browser aciliyo ama 4 den oncekilerde acilmiyor

        WebDriver driver = new ChromeDriver();//now action will happen we open the web driver

        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.etsy.com/");

        driver.manage().window().maximize();

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.close();// it will close one tab
        //driver.quit();// close all tab//dont use both




    }
}
