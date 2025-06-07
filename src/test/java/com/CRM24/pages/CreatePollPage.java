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

    @FindBy(xpath = "//input[@id='question_0']")
    public WebElement questionInput;

    @FindBy(xpath = "//input[@id='answer_0__0_']")
    public WebElement answer1Input;

    @FindBy(xpath = "//input[@id='answer_0__1_']")
    public WebElement answer2Input;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;


}



