package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement inputUsername;

    @FindBy(name = "USER_PASSWORD")
    public WebElement inputPassword;

    @FindBy(className = "login-btn")
    public WebElement loginButton;


    public void login(String username, String password) {
        this.inputUsername.sendKeys(username);
        this.inputPassword.sendKeys(password);
        this.loginButton.click();
    }

    public void login() {
        this.inputUsername.sendKeys("hr10@cydeo.com");
        this.inputPassword.sendKeys("UserUser");
        this.loginButton.click();


    }
    public void login(String userType) {
        String username ;
        String password = "UserUser";  // Assuming all users share this password

        switch (userType.trim().toLowerCase()) {
            case "helpdesk":
                username = "helpdesk10@cydeo.com";
                break;
            case "marketing":
                username = "marketing10@cydeo.com";
                break;
            case "hr":
                username = "hr10@cydeo.com";
                break;
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
}
}