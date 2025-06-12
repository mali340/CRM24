package com.CRM24.step_definitions;

import com.CRM24.pages.ActivityStreamPage;
import com.CRM24.utilities.BrowserUtils;
import com.CRM24.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SendingMessage_stepDefinition {


    ActivityStreamPage activityStreamPage = new ActivityStreamPage();



      @Given("I am on the Activity Stream page")
    public void i_am_on_the_Activity_Stream_page() {
        String currentURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "stream";
        Assert.assertTrue(currentURL.contains(expectedInURL));

    }

    @And("user click on the message tab")
    public void userClickOnTheMessageTab() {
          activityStreamPage.messageTab.click();

          BrowserUtils.sleep(3);
    }




    @When("I type {string}")
    public void i_type(String message) {
        Driver.getDriver().switchTo().frame(activityStreamPage.iFrameMessage);
        BrowserUtils.sleep(3);

        activityStreamPage.messageInputBox.sendKeys(message);

Driver.getDriver().switchTo().parentFrame();
    }


    @When("I click the send button")
    public void i_click_the_send_button() {
        activityStreamPage.sendButton.click();
        BrowserUtils.sleep(3);
    }

    @Then("the message should be visible on the top of the feed with the text {string}")
    public void the_message_should_be_visible_on_the_top_of_the_feed_with_the_text(String message) {
        Assert.assertTrue(activityStreamPage.messageInFeed.isDisplayed());
    }



}
