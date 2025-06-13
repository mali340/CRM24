package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage {


    public AppreciationPage() {

        PageFactory.initElements(Driver.getDriver(),this);

    }

       @FindBy (id = "feed-add-post-form-link-more")
       public WebElement moreButton;


        @FindBy (xpath = "//span[text()='Appreciation']")
        public WebElement appreciation;


        @FindBy (xpath = "//button[@id=\"blog-submit-button-save\"]")
        public WebElement sendButton;

    @FindBy (xpath = "//body[@style='min-height: 184px;']\t")
    public WebElement messageBox;


    @FindBy(className = "feed-add-info-text")
      public WebElement errorMessage;


    @FindBy(xpath = "//a[text()='Add more']")
    public WebElement addMoreButton;

   @FindBy(xpath = "//a[text()='Employees and departments']")
    public WebElement employeesAndDepartmentsButton;


   @FindBy(xpath = "//div/div[text()='Support']")
    public WebElement supportButton;

   @FindBy(className = "popup-window-close-icon")
    public WebElement closeButton;
















}
