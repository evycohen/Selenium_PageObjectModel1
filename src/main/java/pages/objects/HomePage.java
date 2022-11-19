package pages.objects;

import org.openqa.selenium.By;
import pages.dynamicXpath.DynamicXpath;
import pages.page.BasePage;

public class HomePage extends BasePage {
   private final String navBar="//div[@id]//a[text()='%value%']";

   public HomePage clickOnNavBar(String nabVarMenu){
       String newXpath= DynamicXpath.getXpath(navBar,nabVarMenu);
       click(By.xpath(newXpath),nabVarMenu);
       return this;
   }
}
