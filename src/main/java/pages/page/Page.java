package pages.page;

import org.openqa.selenium.By;

public interface Page {

    String getTitle();

    boolean isDisplay(By locator, String fieldName);

    void sendKeys(By locator, String value, String fieldName);

    void click(By locator, String fieldName);
    String getText(By locator,String fieldName);

}
