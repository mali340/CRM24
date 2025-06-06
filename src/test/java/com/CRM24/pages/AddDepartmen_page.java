package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddDepartmen_page {

    public AddDepartmen_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "structure-wrap")
    public WebElement structureEmployee;

    @FindBy(xpath = "//span[@class='webform-small-button-icon']")
    public WebElement addDepartment;

    @FindBy(id = "NAME")
    public WebElement deparmentName;

    @FindBy(id = "IBLOCK_SECTION_ID")
    public WebElement parentDepartment_Dropdown;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement addButton;

    @FindBy(css = "a[title='Whatever']")
    public WebElement displayedDepartment;

    public void selectSectionByVisibleText(String text){
        Select dropdown = new Select(parentDepartment_Dropdown);
        dropdown.selectByVisibleText("Department");
    }

}