package pages.page;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import logger.MyLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import report.ExtentLogger;

public class BasePage implements Page {
    @Override
    public String getTitle() {
        String title= DriverManager.getDriver().getTitle();
        MyLogger.info(getClass(),"Page Title: "+title);
        ExtentLogger.pass("Page Title: "+title);
        return title;
    }

    @Override
    public boolean isDisplay(By locator, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.performExplicit(locator,WaitStrategy.PRESENCE);
            element.isDisplayed();
            String passMessage=fieldName+ " Is Displayed";
            MyLogger.info(getClass(),passMessage);
            ExtentLogger.pass(passMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            String failMessage=fieldName+" Is Not Displayed";
            MyLogger.info(getClass(),failMessage);
            ExtentLogger.fail(failMessage);
            return false;
        }
    }

    @Override
    public void sendKeys(By locator, String value, String fieldName) {
        try{
            WebElement element= ExplicitWaitFactory.performExplicit(locator, WaitStrategy.VISIBLE);
            element.sendKeys(value);
            String passMessage="Sent Keys to "+fieldName+":"+value;
            MyLogger.info(getClass(),passMessage);
            ExtentLogger.pass(passMessage);
        }catch (Exception e) {
            e.printStackTrace();
            String failMessage="Failed to Send Keys to: "+fieldName;
            MyLogger.info(getClass(),failMessage);
            ExtentLogger.fail(failMessage);
        }

    }

    @Override
    public void click(By locator, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.performExplicit(locator,WaitStrategy.CLICKABLE);
            element.click();
            String passMessage="Clicked on: "+fieldName;
            MyLogger.info(getClass(),passMessage);
            ExtentLogger.pass(passMessage);
        }catch (Exception e){
            e.printStackTrace();
            String failMessage="Failed to click on "+fieldName;
            MyLogger.info(getClass(),failMessage);
            ExtentLogger.fail(failMessage);
        }

    }

    @Override
    public String getText(By locator, String fieldName) {
        try{
            WebElement element=ExplicitWaitFactory.performExplicit(locator,WaitStrategy.PRESENCE);
            String text=element.getText();
            String passMsg=fieldName+" Text: "+text;
            MyLogger.info(getClass(),passMsg);
            ExtentLogger.pass(passMsg);
            return text;

        }catch (Exception e){
            e.printStackTrace();
            String failMessage="Failed to return Text from "+fieldName;
            MyLogger.info(getClass(),failMessage);
            ExtentLogger.fail(failMessage);
            return null;
        }
    }
}
