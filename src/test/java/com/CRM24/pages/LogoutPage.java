package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
//the Webelement we should click before we see the logOut button
    @FindBy(id = "user-block")
    public WebElement userMenu;

    //log out button
    @FindBy(xpath = ".//span[text()='Log out']")
    public WebElement logOutBtn;

    //logout method
    public void logOut() {
        this.userMenu.click();
        this.logOutBtn.click();
    }
}
