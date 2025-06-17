package com.CRM24.pages;


import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ConfigOptionsPage extends BasePage{


    @FindBy(xpath = "//span[contains(@class, 'menu-popup-item-text')]")
    public WebElement firstOption;

    @FindBy(className = "menu-favorites-btn-done")
    public WebElement saveBtn;

    @FindBy(xpath = "//span[normalize-space()='Collapse menu']")
    public WebElement secondOption;

    @FindBy(id = "left-menu-resizer-button")
    public WebElement collapseBtn;

    @FindBy(xpath = "//span[normalize-space()='Remove current page from left menu']")
    public WebElement thirdOption;

    @FindBy(xpath = "//span[text()='Add custom menu item']")
    public WebElement fourthOption;

    @FindBy(xpath = "//span[contains(@class,'popup-window-button-link-cancel')]")
    public WebElement CloseBtn;

    @FindBy(xpath = "//span[normalize-space()='Change primary tool']")
    public WebElement fifthOption;

    @FindBy(className = "left-menu-popup-close-item")
    public WebElement closeItem;

    @FindBy(xpath = "//span[normalize-space()='Reset menu']")
    public WebElement sixthOption;


    public void handleAlertIfPresent() {
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            // No alert to handle
        }
    }


    public WebElement getElementForMenuOption(String optionName) {
        optionName = optionName.toLowerCase().trim();

        switch (optionName) {
            case "configure menu items": return saveBtn;
            case "collapse menu": return collapseBtn;
            case "add custom menu item": return CloseBtn;
            case "change primary tool": return closeItem;
            case "remove current page from left menu":
            case "reset menu":
                return null;
            default:
                throw new IllegalArgumentException("Unknown menu option: " + optionName);
        }
    }


    public WebElement getMenuOption(String optionName) {
        Map<String, WebElement> menuMap = new HashMap<>();
        menuMap.put("configure menu items", firstOption);
        menuMap.put("collapse menu", secondOption);
        menuMap.put("remove current page from left menu", thirdOption);
        menuMap.put("add custom menu item", fourthOption);
        menuMap.put("change primary tool", fifthOption);
        menuMap.put("reset menu", sixthOption);

        WebElement element = menuMap.get(optionName.toLowerCase().trim());

        if (element == null) {
            throw new IllegalArgumentException("No such menu option: " + optionName);
        }

        return element;
    }
}