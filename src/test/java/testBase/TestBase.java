package testBase;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setup(){
        DriverManager.initDriver();
    }
    @AfterMethod
    public void tearDown(){
        DriverManager.removeDriver();
    }



}
