package com.CRM24.step_definitions;


import com.CRM24.pages.AppreciationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Appreciation_stepDefinition {

    AppreciationPage appreciationPage = new AppreciationPage();

    @Given("User is on the log in page")
    public void user_is_on_the_log_in_page() {


    }


    @Then("User clicks the {string} tab and selects {string}")
    public void user_clicks_the_tab_and_selects(String more, String appreciation) {

        appreciationPage.moreButton.click();
        appreciationPage.appreciation.click();


    }
    @Then("User enters an appreciation message")
    public void user_enters_an_appreciation_message() {
        appreciationPage.messageBox.sendKeys("Appreciation Message");

    }
    @Then("User clicks the {string} button")
    public void user_clicks_the_button(String send) {
         appreciationPage.sendButton.click();

    }
    @Then("The appreciation should be posted in the stream")
    public void the_appreciation_should_be_posted_in_the_stream() {




    }



}
