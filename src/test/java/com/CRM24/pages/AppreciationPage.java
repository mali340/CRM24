package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage {


    public AppreciationPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(id = "checkbox-windows")
    public WebElement windowsCheckbox;


    @FindBy(xpath = "checkbox-macos")
    public WebElement macCheckbox;


    @FindBy(xpath = "checkbox-linux")
    public WebElement linuxCheckbox;

    @FindBy(id = "download-button")
    public WebElement downloadButton;

    public void selectDesktopVersions() {
        windowsCheckbox.click();
        macCheckbox.click();
        linuxCheckbox.click();
    }
}