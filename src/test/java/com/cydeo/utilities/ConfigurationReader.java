package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



    private static Properties properties = new Properties();//1

    static{

        try {
            //2- Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory//kullandiktan sonra  bize memory save yaptirir, because its alreadl loaded in the object
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");//error mesage istersen, baska bir error atmasini kaldirdi bunu koydu
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }





}
/*in this class, we will be creating reusable logic to read from configuration.properties file
 * everything going to be reusuable not hard coded*/
//1 create the properties object//make it private
//"static" is to make sure its created and loaded before everything else.
//2 open the file using fileinputstream
//3 load the "properties " object with file
//create a utility method to use the object to read
//4 use "properties" object to read from the file(read properties)

//I have configuration properties file to keep my keys and values so i have my configuration reading utility class, so I load
//my config porpery files in this utility by using fileinput stream method