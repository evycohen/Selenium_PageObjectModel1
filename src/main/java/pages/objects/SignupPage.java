package pages.objects;

import org.openqa.selenium.By;
import pages.page.BasePage;

public class SignupPage extends BasePage {
    private final By firstName= By.id("FirstName");
    private final By sureName=By.id("Surname");
    private final By email=By.id("E_post");
    private final By mobile=By.id("Mobile");
    private final By userName=By.id("Username");
    private final By password=By.id("Password");
    private final By confirmPassword=By.id("ConfirmPassword");
    private final By submitBtn=By.id("submit");
    private final By successSignupMsg=By.cssSelector(".label-success");

    public SignupPage setFirstName(String firstName){
        sendKeys(this.firstName,firstName,"firstName");
        return this;
    }
    public SignupPage setSureName(String sureName){
        sendKeys(this.sureName,sureName,"sureName");
        return this;
    }
    public SignupPage setEmail(String email){
        sendKeys(this.email,email,"email");
        return this;
    }
    public SignupPage setMobile(String mobile){
        sendKeys(this.mobile,mobile,"mobile");
        return this;
    }
    public SignupPage setUserName(String userName){
        sendKeys(this.userName,userName,"userName");
        return this;
    }
    public SignupPage setPassword(String password){
        sendKeys(this.password,password,"password");
        return this;
    }
    public SignupPage setConfirmPassword(String confirmPassword){
        sendKeys(this.confirmPassword,confirmPassword,"confirmPassword");
        return this;
    }
    public SignupPage clickSubmit(){
        click(this.submitBtn,"submitBtn");
        return this;
    }
    public String getSuccessSignupMsg(){
        return getText(this.successSignupMsg,"SuccessSignupMessage");
    }

}
