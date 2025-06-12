package com.CRM24.pages;


import com.CRM24.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
}
