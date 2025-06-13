package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePollPage {

    public CreatePollPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "feed-add-post-form-tab-vote")
    public WebElement pollTab;

    @FindBy(xpath = "//iframe[contains(@class, 'bx-editor-iframe')]")
    public WebElement iframe;

    @FindBy(xpath = "//body")
    public WebElement messageBody;

    @FindBy(xpath = "//input[@id='question_0']")
    public WebElement questionInput;

    @FindBy(xpath = "//input[@placeholder='Answer  1']")
    public WebElement answer1Input;

    @FindBy(xpath = "//input[@placeholder='Answer  2']")
    public WebElement answer2Input;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;
}




