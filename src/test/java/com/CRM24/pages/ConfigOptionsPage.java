package com.CRM24.pages;


import com.CRM24.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigOptionsPage extends BasePage{



@FindBy(xpath ="//span[contains(@class, 'menu-popup-item-text')]")
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

   public void handleAlertIfPresent () {
       try {
           Alert alert = Driver.getDriver().switchTo().alert();
           System.out.println("Alert text: " + alert.getText());
           alert.accept();
       } catch (NoAlertPresentException e) {

       }


   }


}
