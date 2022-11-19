package pages.objects;

import org.openqa.selenium.By;
import pages.page.BasePage;
public class AddNewCustomerPage extends BasePage {
    private final By name= By.id("Name");
    private final By company=By.id("Company");
    private final By address=By.id("Address");
    private final By city=By.id("City");
    private final By phone=By.id("Phone");
    private final By email=By.id("Email");
    private final By createBtn=By.cssSelector("input[value='Create']");

    public AddNewCustomerPage setCustomerName(String name){
        sendKeys(this.name,name,"name");
        return this;
    }
    public AddNewCustomerPage setCustomerCompany(String company){
        sendKeys(this.company,company,"customer company");
        return this;
    }
    public AddNewCustomerPage setCustomerAddress(String address){
        sendKeys(this.address,address,"customer address");
        return this;
    }
    public AddNewCustomerPage setCustomerCity(String city){
        sendKeys(this.city,city,"customer city");
        return this;
    }
    public AddNewCustomerPage setCustomerPhone(String phone){
        sendKeys(this.phone,phone,"customer phone");
        return this;
    }
    public AddNewCustomerPage setCustomerEmail(String email){
        sendKeys(this.email,email,"customer email");
        return this;
    }
    public DashBoardPage clickCreateNewCustomerBtn(){
        click(this.createBtn,"create new customer");
        return new DashBoardPage();
    }



}
