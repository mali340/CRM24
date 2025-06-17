package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStreamPage {

    public ActivityStreamPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(css="#feed-add-post-form-tab-message")
    public WebElement messageTab;

    @FindBy(xpath = "//body[@contenteditable='true']")
    //@FindBy(xpath = "//body[@style='min-height: 119px;']")
    public WebElement messageTextArea;

    @FindBy(xpath = "//*[@id=\"blog-submit-button-save\"]")
    public WebElement sendButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    //@FindBy(xpath = "//iframe[contains(@class, 'bx-editor-iframe')]")
        public WebElement iFrameMessage;

    @FindBy(xpath = "//div[contains(@id,'blog_post_body_')]")
    public WebElement messageInFeed;


    @FindBy(id ="user-name")
    public WebElement userAccount;

    @FindBy(xpath = "//*[@id=\"blog-submit-button-cancel\"]")
    public WebElement cancelButton;



}

