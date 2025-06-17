package com.CRM24.step_definitions;

import com.CRM24.pages.ActivityStreamPage;
import com.CRM24.pages.LoginPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.ConfigurationReader;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendingMessage_stepDefinition {


    ActivityStreamPage activityStreamPage = new ActivityStreamPage();
    LoginPage loginPage = new LoginPage();

    @Given("I am logged into Activity Stream Page with {string} and {string}")
    public void iAmLoggedIntoActivityStreamPageWithAnd(String userName, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.login(userName, password);

        Assert.assertTrue(activityStreamPage.userAccount.isDisplayed());

        BrowserUtils.sleep(3);

    }


    @When("I click on the message tab")
    public void userClickOnTheMessageTab() {

        BrowserUtils.waitForClickablility(activityStreamPage.messageTab, 10).click();
        //activityStreamPage.messageTab.click();

        BrowserUtils.sleep(3);
    }



    @And("I type {string}")
    public void i_type(String message) {

        BrowserUtils.waitForVisibility(activityStreamPage.iFrameMessage, 10);

        Driver.getDriver().switchTo().frame(activityStreamPage.iFrameMessage);

        BrowserUtils.waitForVisibility(activityStreamPage.messageTextArea, 10);

        activityStreamPage.messageTextArea.sendKeys(message);

        Driver.getDriver().switchTo().parentFrame();
    }




    @When("I click the send button")
    public void i_click_the_send_button() {

        BrowserUtils.waitForClickablility(activityStreamPage.sendButton, 15).click();

    }


    @Then("the message should be visible on the top of the feed with the text {string}")
    public void the_message_should_be_visible_on_the_top_of_the_feed_with_the_text(String expectedMessage) {

        BrowserUtils.waitForVisibility(activityStreamPage.cancelButton, 10).click();

        Assert.assertEquals(expectedMessage,activityStreamPage.messageInFeed.getText());

    }



    @Then("I am able to cancel the message before sending")
    public void iAmAbleToCancelTheMessageBeforeSending() {


        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(activityStreamPage.cancelButton));
        activityStreamPage.cancelButton.click();


        boolean isDisplayed;
        try {
            isDisplayed = activityStreamPage.messageInFeed.isDisplayed();
        } catch (Exception e) {
            isDisplayed = false;
        }

        Assert.assertTrue("message is still here", isDisplayed);
    }
    }


