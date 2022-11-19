package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

    public static WebElement performExplicit(By locator, WaitStrategy waitStrategy){
        WebElement element=null;
        if(waitStrategy==WaitStrategy.CLICKABLE){
            element=getWait().until(ExpectedConditions.elementToBeClickable(locator));
        }
        else if(waitStrategy==WaitStrategy.PRESENCE){
            element=getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        else if(waitStrategy==WaitStrategy.VISIBLE){
            element=getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        else if(waitStrategy==WaitStrategy.NONE){
            element=DriverManager.getDriver().findElement(locator);
        }
        return element;

    }

    private static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()));
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofMillis(FrameworkConstants.getExplicitMilliSecWait()));
        return wait;
    }
}
