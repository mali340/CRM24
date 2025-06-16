package com.CRM24.pages;

import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement userName;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement submit;

    @FindBy(css = "div[class='errortext']")
    public WebElement errorMessage;

@FindBy(xpath = "//label[.='Remember me on this computer']")
public WebElement rememberMeMessage;


@FindBy(xpath = "//input[@type='checkbox']")
public WebElement rememberMeCheckBox;


    public void login(String userType){
        String usernameValue = "";
        String passwordValue = "";

        switch (userType.toLowerCase()) {
            case "hr":
               usernameValue = ConfigurationReader.getProperty("HR_username");
               passwordValue = ConfigurationReader.getProperty("HR_password");

                 //usernameValue = System.getenv("hr_username");
                 //passwordValue = System.getenv("hr_password");
                break;

            case "helpdesk":
                 usernameValue = ConfigurationReader.getProperty("Helpdesk_username");
                 passwordValue = ConfigurationReader.getProperty("Helpdesk_password");

                 //usernameValue = System.getenv("helpdesk_username");
                 //passwordValue = System.getenv("helpdesk_password");
                break;

            case "marketing":
                usernameValue = ConfigurationReader.getProperty("Marketing_username");
                passwordValue = ConfigurationReader.getProperty("Marketing_password");

                // usernameValue = System.getenv("marketing_username");
                // passwordValue = System.getenv("marketing_password");
                break;

            default:
                System.out.println("Invalid user type");
                return;
        }

        this.userName.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue);
        this.submit.click();

    }

    public void invalidLogin(String usernameValue, String passwordValue){

        this.userName.sendKeys(usernameValue);
        this.password.sendKeys(passwordValue);
        this.submit.click();
    }




}
