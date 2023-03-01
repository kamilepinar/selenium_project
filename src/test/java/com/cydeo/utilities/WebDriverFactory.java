package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

   public static WebDriver getDriver(String browserType){
       if(browserType.equalsIgnoreCase("Chrome")){
           WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

       } else if (browserType.equalsIgnoreCase("FireFox")) {
           WebDriverManager.firefoxdriver().setup();
           return new FirefoxDriver();
       } else if (browserType.equalsIgnoreCase("Edge")) {
           WebDriverManager.edgedriver().setup();
           return new EdgeDriver();
       }else if (browserType.equalsIgnoreCase("safari")){
           WebDriverManager.safaridriver().setup();
           return new SafariDriver();
       }else{
           System.out.println("Given String does not represent any browser");
           System.out.println("Eighter that browser does not exist or not currently supported");
           System.out.println("Driver = Null");
           return null;
       }



   }





}
