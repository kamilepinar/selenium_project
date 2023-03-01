package com.cydeo.tests.day08_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_test() throws IOException {
        //STEPS TO READ FROM PROPERTIES TYPE OF FILE

        Properties properties = new Properties(); // we created our object

        // we open in our java memory using fileinputstream
        FileInputStream file =new FileInputStream("configuration.properties");

        //load the properties file in the properties object
        properties.load(file); //io exception veriyor burda fle  ve yukarda ne fileinput o yuzden methoda exception trows koyduk



        //4- Use the "properties" object to read value from the file
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));
        System.out.println("properties.getProperty(\"password\") = " + properties.getProperty("password"));
    }


}
