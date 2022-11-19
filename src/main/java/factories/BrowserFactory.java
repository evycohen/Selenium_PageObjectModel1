package factories;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import logger.MyLogger;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

public class BrowserFactory {
    private BrowserFactory(){}
    private static WebDriver driver=null;
    public static WebDriver setBrowser(){
        String browserType= PropertyReader.getValue(ConfigProperties.BROWSER);
        if(browserType.equalsIgnoreCase("chrome")){
            driver= WebDriverManager.chromedriver().create();
        }
        else if(browserType.equalsIgnoreCase("firefox")){
            driver=WebDriverManager.firefoxdriver().create();
        }
        MyLogger.info(BrowserFactory.class,"Lunching "+browserType+" Browser");
        return driver;
    }
}
