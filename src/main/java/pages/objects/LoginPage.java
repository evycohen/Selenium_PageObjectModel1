package pages.objects;

import org.openqa.selenium.By;
import pages.page.BasePage;

public class LoginPage extends BasePage {
    private final By userName= By.id("Username");
    private final By password=By.id("Password");
    private final By loginBtn=By.name("login");

    public LoginPage setUserName(String userName){
        sendKeys(this.userName,userName,"userName");
        return this;
    }
    public LoginPage setPassword(String password){
        sendKeys(this.password,password,"password");
        return this;
    }
    public DashBoardPage clickLoginBtn(){
        click(this.loginBtn,"loginBtn");
        return new DashBoardPage();
    }


}
