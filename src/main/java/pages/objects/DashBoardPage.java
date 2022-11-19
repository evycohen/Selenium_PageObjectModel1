package pages.objects;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.dynamicXpath.DynamicXpath;
import pages.page.BasePage;

public class DashBoardPage extends BasePage {
    private final By logoutBtn= By.xpath("//a[text()='Log out']");
    private final By createNewCustomerBtn=By.cssSelector("a.btn-primary");
    private final By searchingBar=By.name("searching");
    private final By searchBtn=By.cssSelector("input[value='Search']");

    public  boolean logoutDisplayStatus(){
        return isDisplay(this.logoutBtn,"LogoutBtn");
    }
    public AddNewCustomerPage clickCreateNewCustomer(){
        click(this.createNewCustomerBtn,"create new customer button");
        return new AddNewCustomerPage();
    }
    public boolean searchCustomerByMail(String mail){
        sendKeys(this.searchingBar,mail,"Searching bar input");
        click(this.searchBtn,"search btn");
        int size=DriverManager.getDriver().findElements(By.xpath("//table//tr//td")).size();
        for(int i =1;i<=size;i++){
            WebElement element=DriverManager.getDriver().findElement(By.xpath("//table//tr//td["+i+"]"));
            if(element.getText().equalsIgnoreCase(mail)){
                return true;
            }

        }return false;
    }

}
