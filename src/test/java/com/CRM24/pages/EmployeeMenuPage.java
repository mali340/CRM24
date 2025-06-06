package com.CRM24.pages;

import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EmployeeMenuPage {

    public EmployeeMenuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a.menu-item-link[title='Employees']")
    public WebElement employeesMenu;

    @FindBy(xpath = "//span[@class='menu-item-link-text']")
    private List<WebElement> moduleElements;

    public int getModuleNumber() {
        return BrowserUtils.getElementsText(this.moduleElements).size();



    }

}
