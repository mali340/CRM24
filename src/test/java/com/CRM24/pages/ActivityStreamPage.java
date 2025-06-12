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



    @FindBy(xpath = "//span[@id='feed-add-post-form-tab-message']")
    public WebElement messageTab;

    @FindBy(xpath = "//body[@contenteditable ='true']")
    public WebElement messageInputBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(css = "iframe[class='bx-editor-iframe']")
        public WebElement iFrameMessage;

    @FindBy(xpath = "//div[@class ='feed-post-text-block-inner-inner']")
    public WebElement messageInFeed;




}
