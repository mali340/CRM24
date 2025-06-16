package com.CRM24.pages;

import com.CRM24.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.logging.XMLFormatter;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[.='Task']")
    public WebElement taskButton;

    @FindBy(xpath = "//input[@data-bx-id='task-edit-title']")
    public WebElement tasksTitle;

    @FindBy(xpath = "(//iframe[@class='bx-editor-iframe'])[2]")
    public WebElement tasksBodyIframe;


    @FindBy(xpath = "//body[@style='min-height: 84px;']")
    public WebElement taskBodyElement;


    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@class='feed-task-info-text-title']")
    public WebElement newTaskInFeed;


    @FindBy(className = "popup-window-close-icon")
    public WebElement popupExit;


    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;


    @FindBy(xpath = "//span[.='Send message …']")
    public WebElement sendMessageArea;


    @FindBy (xpath = "//a[@title='Tasks']")
    public WebElement tasksLink;

    @FindBy (xpath = "//a[@class='menu-item-plus-icon']")
    public WebElement additionSign;


    @FindBy (xpath = "//a[@id='tasks-buttonAdd']")
    public WebElement newTaskButton;

    @FindBy (xpath = "//span[@data-bx-id='task-edit-cmd']")
    public WebElement addTaskButton;


    @FindBy(xpath = "//a[@class='task-title task-status-text-color-accepted']")
    public WebElement newTaskInMyTasksFeed;


    @FindBy (xpath = "//iframe[@class='side-panel-iframe']")
    public WebElement newTaskIframe;


    @FindBy(xpath = "//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']")
    public WebElement newTaskTitle;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement newTaskBodyIframe;

    @FindBy(xpath = "//body[@style='min-height: 84px;']")
    public WebElement newTaskBodyElement;




}
