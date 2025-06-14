package com.CRM24.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Configuration_Menu extends BasePage{


    @FindBy(id = "left-menu-settings")
    public WebElement ConfigureLink;

    @FindBy(xpath = "//span[contains(@class, 'menu-popup-item-text')]")
    public List<WebElement> ConfigureMenuOptions;
}
