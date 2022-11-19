package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import factories.BrowserFactory;
import logger.MyLogger;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

import java.time.Duration;
import java.util.Objects;

public class DriverManager {
    private DriverManager(){}
    private static WebDriver driver;
    public static void initDriver(){
        if(Objects.isNull(driver)){
            driver= BrowserFactory.setBrowser();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWait()));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageLoadTime()));
            driver.manage().window().maximize();
            driver.get(PropertyReader.getValue(ConfigProperties.URL));
            MyLogger.info(DriverManager.class,"Open Url: "+PropertyReader.getValue(ConfigProperties.URL));
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void removeDriver(){
        MyLogger.info(DriverManager.class,"Quiting Driver");
        if(Objects.nonNull(driver)){
            driver.quit();
            driver=null;
        }
    }

}
